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

This activity defines the UI of video list to be clicked and played.
 */

package com.google.android.exoplayer.demo;

import com.google.android.exoplayer.demo.Samples.Sample;
import com.google.android.exoplayer.demo.full.FullPlayerActivity;
import com.google.android.exoplayer.demo.simple.SimplePlayerActivity;
import com.google.android.exoplayer.util.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An activity for selecting from a number of samples.
 */
public class SampleChooserActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sample_chooser_activity);

    ListView sampleList = (ListView) findViewById(R.id.sample_list);
    final SampleAdapter sampleAdapter = new SampleAdapter(this);

     sampleAdapter.add(new Header("Readme First"));
     sampleAdapter.addAll((Object[]) Samples.Readme); //yan
      sampleAdapter.add(new Header("Study 1"));
      sampleAdapter.addAll((Object[]) Samples.Instr1); //yan
      sampleAdapter.add(new Header("Big Buck Bunny"));
      sampleAdapter.addAll((Object[]) Samples.Big_Buck_Bunny); //yan

    /* CODE TO MEASURE THE POWER (Yan)
     //start Trepn Profiler
     Intent trepnProfiler = new Intent();
     trepnProfiler.setClassName("com.quicinc.trepn", "com.quicinc.trepn.TrepnService");
     startService(trepnProfiler);
     // load a .pref file Trepn
     Intent loadPreferences = new Intent("com.quicinc.trepn.load_preferences");
     loadPreferences.putExtra("com.quicinc.trepn.load_preferences_file", "file:///storage/emulated/0/trepn/saved_preferences/LCDpower.pref");
     sendBroadcast(loadPreferences);
    */

    sampleList.setAdapter(sampleAdapter);
    sampleList.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object item = sampleAdapter.getItem(position);
        if (item instanceof Sample) {
          onSampleSelected((Sample) item);
        }
      }
    });
  }

  private void onSampleSelected(Sample sample) {
    if (sample.uri.equals("readme")) { // if "readme" is hit (Yan)
        Intent readmeIntent = new Intent(this, ReadmeActivity.class);
        startActivity(readmeIntent);
    }
    else if (sample.uri.equals("instr")) { // if an instruction of test is hit (Yan)
        Intent instrIntent = new Intent(this, InstrActivity.class);
        instrIntent.putExtra("INSTR_INDEX_EXTRA", sample.contentId);
        startActivity(instrIntent);
    }
    else { // if the name of a clip to play the video
        if (Util.SDK_INT < 18 && sample.isEncypted) {
            Toast.makeText(getApplicationContext(), R.string.drm_not_supported, Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        Class<?> playerActivityClass = sample.fullPlayer ? FullPlayerActivity.class
                : SimplePlayerActivity.class;
        Intent mpdIntent = new Intent(this, playerActivityClass) // get some content metadata for statistics collection
                .setData(Uri.parse(sample.uri))
                .putExtra(DemoUtil.CONTENT_ID_EXTRA, sample.contentId)
                .putExtra(DemoUtil.CONTENT_TYPE_EXTRA, sample.type)
                .putExtra(DemoUtil.NAME_EXTRA, sample.name); //yan
        startActivity(mpdIntent);
    }
  }

  private static class SampleAdapter extends ArrayAdapter<Object> {

    public SampleAdapter(Context context) {
      super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = convertView;
      if (view == null) {
        int layoutId = getItemViewType(position) == 1 ? android.R.layout.simple_list_item_1
            : R.layout.sample_chooser_inline_header;
        view = LayoutInflater.from(getContext()).inflate(layoutId, null, false);
      }
      Object item = getItem(position);
      String name = null;
      if (item instanceof Sample) {
        name = ((Sample) item).name;
      } else if (item instanceof Header) {
        name = ((Header) item).name;
      }
      ((TextView) view).setText(name);
      return view;
    }

    @Override
    public int getItemViewType(int position) {
      return (getItem(position) instanceof Sample) ? 1 : 0;
    }

    @Override
    public int getViewTypeCount() {
      return 2;
    }

  }

  private static class Header {

    public final String name;

    public Header(String name) {
      this.name = name;
    }

  }
}