package com.android_project.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button b;
    DatePicker dp;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.b);
        dp = (DatePicker) findViewById(R.id.dp);
        tv = (TextView) findViewById(R.id.tv);

        Calendar c = Calendar.getInstance();

        int yr = c.get(Calendar.YEAR);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int birth_yr = dp.getYear();
                tv.setText("Age: "+(yr - birth_yr));
            }
        });
    }
}