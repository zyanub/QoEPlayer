/*
Implemented by Zhisheng Yan, State University of New York at Buffalo.
Please cite this paper when using the code:
Zhisheng Yan, Qian Liu, Tong Zhang, Chang Wen Chen, "Exploring QoE for Power Efficiency: A Field Study on Mobile Videos
with LCD Displays", ACM Multimedia Conference (MM), Brisbane, Australia, Oct. 2015.
Contact: zyan3@buffalo.edu

This activity describes the Readme page, where general instruction are presented and the information of participants
are entered and possibly saved. Also, the test environment, e.g., light, are checked here.
*/

package com.google.android.exoplayer.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReadmeActivity extends Activity implements View.OnClickListener,SensorEventListener {

    private TextView LoginStatus;
    private SensorManager mSensorManager; //yan light sensor
    private Sensor mLight;
    private float totLux=0.0f;
    private float totSamples=0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme);

        SharedPreferences loginName = getSharedPreferences("LoginFile", MODE_PRIVATE);
        String curUser= loginName.getString("curUser", "nobody");
        LoginStatus = (TextView) findViewById(R.id.login_status);
        LoginStatus.setText(getString(R.string.signin_msg) +" "+ curUser);
        findViewById(R.id.button_ack_readme).setOnClickListener(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //YAN light sensor
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight==null) {//no light sensor
            Toast.makeText(this, "No light sensor in this device", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) { //yan light sensor
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {//yan light sensor
        totLux = totLux+event.values[0];
        totSamples =  totSamples+1.0f;
        Log.d("LIGHT", "Currently with Light:" + event.values[0]);
    }

    @Override
    public void onResume() {
        super.onResume();
        // yan light sensor
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onClick(View v) {
        EditText mFirstName = (EditText) findViewById(R.id.first_name_readme);
        EditText mLastName = (EditText) findViewById(R.id.last_name_readme);
        String first_name = mFirstName.getText().toString();
        String last_name = mLastName.getText().toString();
        int id = v.getId();
        if(id==R.id.button_ack_readme){
            // save some user input information, e.g., for simplicity, we only show the code of recording user name here
            SharedPreferences loginName = getSharedPreferences("LoginFile", MODE_PRIVATE);
            SharedPreferences.Editor editor = loginName.edit();
            editor.putString("curUser", first_name+last_name);
            // Commit the edits!
            if (editor.commit()) {
                // if commit successfully Change the UI
                LoginStatus.setText(getString(R.string.signin_msg) + first_name + last_name);
                Toast.makeText(this, "Successfully signed in!", Toast.LENGTH_LONG).show();
            }
            //yan  CHECK THE LIGHT SENSOR TO SEE IF THE ENVIRONMENT IS OK
            float avgLux=totLux/totSamples;
            Log.d("LIGHT", "totLux: " + totLux + "totSamp: " + totSamples+"avg: "+avgLux);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (avgLux>100&&avgLux<1000) {

            }
            else {
                if (avgLux < 100) {
                    builder.setMessage("Your watching environment is too dark! Please make sure your fingers do not block the light sensor near the headphone port and then go to a lighter environment and sign in again.");
                } else if (avgLux > 1000) {
                    builder.setMessage("Your watching environment is too bright! Please go to a darker environment and sign in again.");
                }
                builder.setPositiveButton("OK, got it!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // going back to the main activity
                        Intent i=new Intent(ReadmeActivity.this, SampleChooserActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                });
                AlertDialog accDialog = builder.create();
                accDialog.show();
            }
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_readme, menu);
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