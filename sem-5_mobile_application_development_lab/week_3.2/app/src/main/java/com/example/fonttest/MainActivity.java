package com.example.fonttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        String value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        CheckBox c1 = (CheckBox) findViewById(R.id.c1);
        CheckBox c2 = (CheckBox) findViewById(R.id.c2);
        CheckBox c3 = (CheckBox) findViewById(R.id.c3);
        TextView t1 = (TextView) findViewById(R.id.tv1);
        TextView t2 = (TextView) findViewById(R.id.tv2);
        TextView t3 = (TextView) findViewById(R.id.tv3);
        if(c1.isChecked()) {
            t1.setText("BOLD");
            t1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            if(value.equals("LEFT"))
                t1.setGravity(Gravity.LEFT);
            else if(value.equals("CENTER"))
                t1.setGravity(Gravity.CENTER);
            else
                t1.setGravity(Gravity.RIGHT);
        }
        else
            t1.setText("");
        if(c2.isChecked()) {
            t2.setText("ITALIC");
            t2.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            if(value.equals("LEFT"))
                t2.setGravity(Gravity.LEFT);
            else if(value.equals("CENTER"))
                t2.setGravity(Gravity.CENTER);
            else
                t2.setGravity(Gravity.RIGHT);
        }
        else
            t2.setText("");
        if(c3.isChecked()) {
            t3.setText("NORMAL");
            if(value.equals("LEFT"))
                t3.setGravity(Gravity.LEFT);
            else if(value.equals("CENTER"))
                t3.setGravity(Gravity.CENTER);
            else
                t3.setGravity(Gravity.RIGHT);
        }
        else
            t3.setText("");
    }
}