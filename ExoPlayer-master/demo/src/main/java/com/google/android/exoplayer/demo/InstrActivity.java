/*
Implemented by Zhisheng Yan, State University of New York at Buffalo.
Please cite this paper when using the code:
Zhisheng Yan, Qian Liu, Tong Zhang, Chang Wen Chen, "Exploring QoE for Power Efficiency: A Field Study on Mobile Videos
with LCD Displays", ACM Multimedia Conference (MM), Brisbane, Australia, Oct. 2015.
Contact: zyan3@buffalo.edu

This activity describes the INSTRUCTION page of each test, where specific instruction of a clicked test are presented.
*/

package com.google.android.exoplayer.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class InstrActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instr);

        Intent intent = getIntent();
        String instrIndex = intent.getStringExtra("INSTR_INDEX_EXTRA");
        TextView testInstr = (TextView) findViewById(R.id.test_instr);
        // Based on the metadata of the clicked instruction, to select corresponding instruction
        if (instrIndex.equals("1")) {
            testInstr.setText(getString(R.string.instr1));
        }
        else if (instrIndex.equals("2")){
            testInstr.setText(getString(R.string.instr2));
        }
        else {
            testInstr.setText(getString(R.string.instr3));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instr, menu);
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