/*
Implemented by Zhisheng Yan, State University of New York at Buffalo.
Please cite this paper when using the code:
Zhisheng Yan, Qian Liu, Tong Zhang, Chang Wen Chen, "Exploring QoE for Power Efficiency: A Field Study on Mobile Videos
with LCD Displays", ACM Multimedia Conference (MM), Brisbane, Australia, Oct. 2015.
Contact: zyan3@buffalo.edu

This activity describes the QoE opinion page that is shown after a clip is played. It saves the opinion of a participant
toward a certain clip.
*/

package com.google.android.exoplayer.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.exoplayer.demo.simple.SimplePlayerActivity;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

public class QoEOpinionActivity extends Activity implements OnClickListener{

    private String jnd_index_str;
    private String saving_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qoe_opinion);

        // get the current user name
        SharedPreferences loginName = getSharedPreferences("LoginFile", MODE_PRIVATE);
        String curUser= loginName.getString("curUser", "nobody");
        TextView SigninStatus = (TextView) findViewById(R.id.signin_status);
        SigninStatus.setText(getString(R.string.signin_msg) + " " + curUser);
        // Get the intent message from the player activity
        Intent intent = getIntent();
        saving_name = intent.getStringExtra(SimplePlayerActivity.SAVING_NAME_EXTRA);
        jnd_index_str = intent.getStringExtra(SimplePlayerActivity.JND_INDEX_EXTRA);
        findViewById(R.id.button_ack).setOnClickListener(this);
        findViewById(R.id.button_nack).setOnClickListener(this);
    }

    // how to respond the click of two "submit" buttons: save the opinion to a local file
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.button_nack){
            SharedPreferences loginName = getSharedPreferences("LoginFile", MODE_PRIVATE);
            String curUser= loginName.getString("curUser", "nobody");
            String userInfo=curUser+" "+jnd_index_str+"\n";
            String saving_dir="/QoETest/results/"+saving_name+".txt";
            try {
                String storageState = Environment.getExternalStorageState();
                if (storageState.equals(Environment.MEDIA_MOUNTED)) { // write the opinion into the file
                    File dir = Environment.getExternalStorageDirectory();// get the sd card root dir
                    File newFile = new File(dir, saving_dir);
                    FileWriter fw = new FileWriter(newFile, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(userInfo);
                    bw.flush();
                    bw.close();
                    Toast.makeText(this, "Successfully recorded", Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show();
            }catch (IOException e) {
                e.printStackTrace();
            }
            // going back to the main activity at the same time
            /*Intent i=new Intent(this, SampleChooserActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);*/
        }
        else if (id==R.id.button_ack){
            Toast.makeText(this, "Successfully recorded", Toast.LENGTH_SHORT).show();
            // going back to the main activity
            /*Intent i=new Intent(this, SampleChooserActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qoe_opinion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
