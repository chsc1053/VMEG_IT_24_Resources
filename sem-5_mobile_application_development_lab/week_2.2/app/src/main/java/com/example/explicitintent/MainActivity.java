package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callSecond(View view) {
        Intent i = new Intent(getApplicationContext(),SecondActivity.class);
        i.putExtra("rno", 1270);
        i.putExtra("name", "sai");
        startActivity(i);
    }
}