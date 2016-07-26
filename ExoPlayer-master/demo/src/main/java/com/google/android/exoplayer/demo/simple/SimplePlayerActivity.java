/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
Modified by Zhisheng Yan, State University of New York at Buffalo.
Please cite this paper when using the code:
Zhisheng Yan, Qian Liu, Tong Zhang, Chang Wen Chen, "Exploring QoE for Power Efficiency: A Field Study on Mobile Videos
with LCD Displays", ACM Multimedia Conference (MM), Brisbane, Australia, Oct. 2015.
Contact: zyan3@buffalo.edu

This activity is the activity to play the video in the SimplePlayer. It also implements the dynamic backlight scaling
and some user interaction, e.g., double tap to submit the opinion
 */

package com.google.android.exoplayer.demo.simple;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaCodec.CryptoException;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;

import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.VideoSurfaceView;
import com.google.android.exoplayer.demo.DemoUtil;
import com.google.android.exoplayer.demo.QoEOpinionActivity;
import com.google.android.exoplayer.demo.SampleChooserActivity;
import com.google.android.exoplayer.demo.R;
import com.google.android.exoplayer.util.PlayerControl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Math;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

/**
 * An activity that plays media using {@link ExoPlayer}.
 */
public class SimplePlayerActivity extends Activity implements SurfaceHolder.Callback,
    ExoPlayer.Listener, MediaCodecVideoTrackRenderer.EventListener {

  /**
   * Builds renderers for the player.
   */
  public interface RendererBuilder {

    void buildRenderers(RendererBuilderCallback callback);

  }

  public static final int RENDERER_COUNT = 2;
  public static final int TYPE_VIDEO = 0;
  public static final int TYPE_AUDIO = 1;

  public final static String SAVING_NAME_EXTRA = "saved_file_name"; //yan
  public final static String JND_INDEX_EXTRA = "selected_index";

  private static final String TAG = "PlayerActivity";

  private MediaController mediaController;
  private Handler mainHandler;
  private Handler dbsHandler; //yan
  private Runnable checkScene;//yan
  private View shutterView;
  private VideoSurfaceView surfaceView;

  private ExoPlayer player;
  private RendererBuilder builder;
  private RendererBuilderCallback callback;
  private MediaCodecVideoTrackRenderer videoRenderer;

  private boolean autoPlay = true;
  private boolean firstReady = true; //yan dbs
  private boolean isSingleScene; // yan
  private long playerPosition;

  private Uri contentUri;
  private int contentType;
  private int sceneChangeTime[]; //yan DBS
  private float sceneBacklit[]; //DBS
  private int sceneIndex = 0; //DBS
  private String contentId;
  private String nameString; //yan

  private GestureDetector mDetector; // yan UI
  private File profileFile;

  // Activity lifecycle

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    contentUri = intent.getData();
    contentType = intent.getIntExtra(DemoUtil.CONTENT_TYPE_EXTRA, DemoUtil.TYPE_OTHER);
    contentId = intent.getStringExtra(DemoUtil.CONTENT_ID_EXTRA);
    nameString = intent.getStringExtra(DemoUtil.NAME_EXTRA); // yan

    // if single scene is selected, only one time update
    if (contentId.contains("_sin")) {
        isSingleScene = true;
        sceneBacklit = new float[]{1.0f,0.05f,0.15f,0.25f,0.35f,0.45f,0.55f,0.65f,0.75f,0.85f,0.95f};
       if (!nameString.equals("Original")) { // only single-scene case we will test FULL-BACKLIT video
            sceneIndex = Integer.parseInt(nameString); // if name is "1", take the second value in the above matrix
       }
    }
    else {
        isSingleScene = false;
        //update sceneChangeTime and sceneBacklit from a file
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            String line;
            File dir = Environment.getExternalStorageDirectory();// get the sd card root dir
            profileFile = new File(dir, "/QoETest/profile/"+contentId+".txt");
            /* Use the server where the profile is stored
            if(!profileFile.exists()) { // if the profile is not exited, download it from the server
                String stringUrl = "http://xxx.com/"+contentId+".txt";
                new DownloadWebpageTask().execute(stringUrl);
            }
            */
            try { // read the profile file: first line: shot boundary time; second line: backlight of each shot
                FileReader fr = new FileReader(profileFile);
                BufferedReader br = new BufferedReader(fr);
                boolean isFirstLine=true;
                while ((line = br.readLine()) != null) {
                    String[] oneLine=line.split(",");
                    if (isFirstLine) {
                        sceneChangeTime  = new int[oneLine.length];
                        for( int i = 0; i < oneLine.length; i++ ){
                            sceneChangeTime[i] = Integer.parseInt(oneLine[i]);
                        }
                        isFirstLine=false;
                    }
                    else {
                        sceneBacklit = new float[oneLine.length];
                        for( int i = 0; i < oneLine.length; i++ ){
                            sceneBacklit[i] = Float.parseFloat(oneLine[i]);
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "file not found", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // only for consistency test modified the second shot BL
        /*if (!nameString.equals("TrainingClip")&& (!contentId.contains("up"))) {
            int tmpIndex = Integer.parseInt(nameString);
            sceneBacklit[1] = Math.max(sceneBacklit[1], sceneBacklit[0] - tmpIndex * 0.1f);
        }*/

        // we will test FULL-BACKLIT video as the same scaling frequency;
        if (nameString.equals("Original")) { //this code block is not executed for DBS video
            int i;
            for (i=0;i<sceneBacklit.length;i++) {
                sceneBacklit[i]=1.0f;
            }
        }
    }
    mainHandler = new Handler(getMainLooper());
    builder = getRendererBuilder();

    setContentView(R.layout.player_activity_simple);
    View root = findViewById(R.id.root);
    /*root.setOnTouchListener(new OnTouchListener() {
      @Override
      public boolean onTouch(View arg0, MotionEvent arg1) {
        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
          toggleControlsVisibility();
        }
        return true;
      }
    });*/ // replace by the gesture detector I implemented below override onDown()

    mediaController = new MediaController(this);
    mediaController.setAnchorView(root);
    shutterView = findViewById(R.id.shutter);
    surfaceView = (VideoSurfaceView) findViewById(R.id.surface_view);
    surfaceView.getHolder().addCallback(this);

    DemoUtil.setDefaultCookieManager();

    mDetector = new GestureDetector(this, new MyGestureListener()); //YAN UI
  }

  @Override
  public boolean onTouchEvent(MotionEvent event){ // YAN UI
      this.mDetector.onTouchEvent(event);
      return super.onTouchEvent(event);
  }

  class MyGestureListener extends GestureDetector.SimpleOnGestureListener { //yan ui
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
            toggleControlsVisibility();
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event) { //yan ui
            player.setPlayWhenReady(false); //pause the playback when double tap
            Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
            // Pop up a dialogue
            AlertDialog.Builder builder = new AlertDialog.Builder(SimplePlayerActivity.this);
            builder.setMessage(R.string.acc_ques);
            if (isSingleScene) {
                builder.setNegativeButton(R.string.acc, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(SimplePlayerActivity.this, "Successfully recorded", Toast.LENGTH_SHORT).show();
                        /*// going back to the main activity
                        Intent i=new Intent(SimplePlayerActivity.this, SampleChooserActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);*/
                    }
                });
            }

            builder.setPositiveButton(R.string.unacc, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // when user submit his decision, it clears, if any, previously posted runnables
                    if (!isSingleScene) {
                        dbsHandler.removeCallbacks(checkScene);
                    }
                    // if unacceptable clicked, save user opinion; Because of binary result, we only record one of them
                    SharedPreferences loginName = getSharedPreferences("LoginFile", MODE_PRIVATE);
                    String curUser= loginName.getString("curUser", "nobody");
                    String userInfo=curUser+" "+nameString+"\n";
                    String saving_dir="/QoETest/results/"+contentId+".txt";
                    try {
                        String storageState = Environment.getExternalStorageState();
                        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
                            File dir = Environment.getExternalStorageDirectory();// get the sd card root dir
                            File newFile = new File(dir, saving_dir);
                            FileWriter fw = new FileWriter(newFile, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(userInfo);
                            bw.flush();
                            bw.close();
                            Toast.makeText(SimplePlayerActivity.this, "Successfully recorded", Toast.LENGTH_SHORT).show();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(SimplePlayerActivity.this, "File not found", Toast.LENGTH_LONG).show();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    // going back to the main activity at the same time
                    /*Intent i=new Intent(SimplePlayerActivity.this, SampleChooserActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);*/
                }
            });
            // Create the AlertDialog, asking user a question
            AlertDialog accDialog = builder.create();
            accDialog.show();
            return true;
        }
  }

  @Override
  public void onBackPressed() { //YAN UI
      if (!isSingleScene) { // if this is the multiple-times scaling using handler, remove before exit
          dbsHandler.removeCallbacks(checkScene);
      }
      super.onBackPressed();
  }

  @Override
  public void onResume() {
    super.onResume();
    // Setup the player
    player = ExoPlayer.Factory.newInstance(RENDERER_COUNT, 1000, 5000);
    player.addListener(this);
    player.seekTo(playerPosition);
    // Build the player controls
    mediaController.setMediaPlayer(new PlayerControl(player));
    mediaController.setEnabled(true);
    // Request the renderers
    callback = new RendererBuilderCallback();
    builder.buildRenderers(callback);
  }

  @Override
  public void onPause() {
    super.onPause();
    // Release the player
    if (player != null) {
      playerPosition = player.getCurrentPosition();
      player.release();
      player = null;
    }
    callback = null;
    videoRenderer = null;
    shutterView.setVisibility(View.VISIBLE);
  }

  // Public methods

  public Handler getMainHandler() {
    return mainHandler;
  }

  // Internal methods

  private void toggleControlsVisibility()  {
    if (mediaController.isShowing()) {
      mediaController.hide();
    } else {
      mediaController.show(0);
    }
  }

  private RendererBuilder getRendererBuilder() {
    String userAgent = DemoUtil.getUserAgent(this);
    switch (contentType) {
      case DemoUtil.TYPE_SS:
        return new SmoothStreamingRendererBuilder(this, userAgent, contentUri.toString(),
            contentId);
      case DemoUtil.TYPE_DASH:
        return new DashRendererBuilder(this, userAgent, contentUri.toString(), contentId);
      default:
        return new DefaultRendererBuilder(this, contentUri);
    }
  }

  private void onRenderers(RendererBuilderCallback callback,
      MediaCodecVideoTrackRenderer videoRenderer, MediaCodecAudioTrackRenderer audioRenderer) {
    if (this.callback != callback) {
      return;
    }
    this.callback = null;
    this.videoRenderer = videoRenderer;
    player.prepare(videoRenderer, audioRenderer);
    maybeStartPlayback();
  }

  private void maybeStartPlayback() {
    Surface surface = surfaceView.getHolder().getSurface();
    if (videoRenderer == null || surface == null || !surface.isValid()) {
      // We're not ready yet.
      return;
    }
    player.sendMessage(videoRenderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, surface);
    if (autoPlay) {
      player.setPlayWhenReady(true);
      autoPlay = false;
    }
  }

  private void onRenderersError(RendererBuilderCallback callback, Exception e) {
    if (this.callback != callback) {
      return;
    }
    this.callback = null;
    onError(e);
  }

  private void onError(Exception e) {
    Log.e(TAG, "Playback failed", e);
    Toast.makeText(this, R.string.failed, Toast.LENGTH_SHORT).show();
    finish();
  }

  // ExoPlayer.Listener implementation

  @Override
  public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
      if (firstReady) {
          Log.d(TAG,"get in the function at "+player.getCurrentPosition()+"state:"+playbackState);
      }
      // DBS
      // if we have the first buffering state, we start the scaling. Then use a runnable to find the desired shot boundary,
      // and then set the layoutparameters of the window to change screenBrightness
      if (firstReady && playbackState == ExoPlayer.STATE_BUFFERING) {
          firstReady = false;
          /*
          // Start profiling Trepn   POWER MEASUREMENT
          String dbFileName=contentId+nameString;
          Intent startProfiling = new Intent("com.quicinc.trepn.start_profiling");
          startProfiling.putExtra("com.quicinc.trepn.database_file", dbFileName);
          sendBroadcast(startProfiling);
          */

          // for single scene case
          if (isSingleScene) {
                  updateBacklit(); //only once
          }
          else {
              // handler and runnable for DYNAMIC BACKLIGHT SCALING
              dbsHandler = new Handler();
              checkScene = new Runnable() {
                  @Override
                  public void run() {
                      // to do: take care of fast backward for DBS (current prototype not supported)
                      long current_time = player.getCurrentPosition();
                      if (current_time > sceneChangeTime[sceneIndex] || current_time == sceneChangeTime[sceneIndex]) {
                          while ((sceneIndex < sceneChangeTime.length) && (current_time > sceneChangeTime[sceneIndex] || current_time == sceneChangeTime[sceneIndex])) {
                                sceneIndex = sceneIndex + 1;
                          }
                          sceneIndex = sceneIndex - 1;
                          updateBacklit(); // for "Original" each update is set to 1.0
                          Log.d(TAG, "scene index:"+ sceneIndex + "cur position: " + current_time + " DBS to " + sceneBacklit[sceneIndex] + " for position: " + sceneChangeTime[sceneIndex] );
                          sceneIndex++;
                      }
                      if (current_time < sceneChangeTime[sceneChangeTime.length-1]) {
                          dbsHandler.postDelayed(this, 40);
                      }
                  }
              };
              dbsHandler.post(checkScene);
          }
      }

      if (playbackState == ExoPlayer.STATE_ENDED) {
          // stop profiling the energy POWER MEASUREMENT
          //Intent stopProfiling = new Intent("com.quicinc.trepn.stop_profiling");
          //sendBroadcast(stopProfiling);
          // to trigger a new activity using intent that can be embedded with some message that will be used by new actvty
          Intent mosIntent = new Intent(this, QoEOpinionActivity.class);
          mosIntent.putExtra(SAVING_NAME_EXTRA, contentId);
          mosIntent.putExtra(JND_INDEX_EXTRA, nameString);
          startActivity(mosIntent);
      } // yan

  }

  //DBS update
  private void updateBacklit() {
      Window w = getWindow();
      WindowManager.LayoutParams lp = w.getAttributes();
      lp.screenBrightness = sceneBacklit[sceneIndex];
      if (lp.screenBrightness<.01f) {
          lp.screenBrightness=.01f; // minimum backlit set to 0.01
      }
      w.setAttributes(lp);
  }

  @Override
  public void onPlayWhenReadyCommitted() {
    // Do nothing.
  }

  @Override
  public void onPlayerError(ExoPlaybackException e) {
    onError(e);
  }

  // MediaCodecVideoTrackRenderer.Listener

  @Override
  public void onVideoSizeChanged(int width, int height, float pixelWidthHeightRatio) {
    surfaceView.setVideoWidthHeightRatio(
        height == 0 ? 1 : (pixelWidthHeightRatio * width) / height);
  }

  @Override
  public void onDrawnToSurface(Surface surface) {
    shutterView.setVisibility(View.GONE);
  }

  @Override
  public void onDroppedFrames(int count, long elapsed) {
    Log.d(TAG, "Dropped frames: " + count);
  }

  @Override
  public void onDecoderInitializationError(DecoderInitializationException e) {
    // This is for informational purposes only. Do nothing.
  }

  @Override
  public void onCryptoError(CryptoException e) {
    // This is for informational purposes only. Do nothing.
  }

  // SurfaceHolder.Callback implementation

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    maybeStartPlayback();
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    // Do nothing.
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    if (videoRenderer != null) {
      player.blockingSendMessage(videoRenderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, null);
    }
  }

  /* package */ final class RendererBuilderCallback {

    public void onRenderers(MediaCodecVideoTrackRenderer videoRenderer,
        MediaCodecAudioTrackRenderer audioRenderer) {
      SimplePlayerActivity.this.onRenderers(this, videoRenderer, audioRenderer);
    }

    public void onRenderersError(Exception e) {
      SimplePlayerActivity.this.onRenderersError(this, e);
    }

  }

// FUNCTION TO download the profile file
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.

                try {
                    //set the download URL, a url that points to a file on the internet
                    //this is the file to be downloaded
                    URL url = new URL(urls[0]);
                    long startTime = System.currentTimeMillis();
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    //set up some things on the connection
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoOutput(true);
                    //and connect!
                    conn.connect();
                    //this will be used in reading the data from the internet
                    InputStream inputStream = conn.getInputStream();
                    //this will be used to write the downloaded data into the file we created
                    FileOutputStream fileOutput = new FileOutputStream(profileFile);
                    //this is the total size of the file
                    int totalSize = conn.getContentLength();
                    //variable to store total downloaded bytes
                    int downloadedSize = 0;

                    //create a buffer...
                    byte[] buffer = new byte[10240];
                    int bufferLength = 0; //used to store a temporary size of the buffer

                    //now, read through the input buffer and write the contents to the file
                    while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                        //add the data in the buffer to the file in the file output stream (the file on the sd card
                        fileOutput.write(buffer, 0, bufferLength);
                        //add up the size so we know how much is downloaded
                        downloadedSize += 1;
                    }
                    Log.d("DataRate","loop times:"+downloadedSize+"file size:"+ totalSize+ "download start at"+startTime+"last for" + (System.currentTimeMillis()-startTime));
                    //close the output stream when done
                    fileOutput.close();

//catch some possible errors...
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            //textView.setText(result);
        }

        // Given a URL, establishes an HttpUrlConnection and retrieves
// the web page content as a InputStream, which it returns as
// a string.


    }


}
