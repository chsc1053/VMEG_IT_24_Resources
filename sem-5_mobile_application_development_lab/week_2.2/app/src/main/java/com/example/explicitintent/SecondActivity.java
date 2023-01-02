package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        int rno = bundle.getInt("rno");
        String name = bundle.getString("name");
        Toast.makeText(getApplicationContext(),"Roll No: " + rno + " Name: " + name, Toast.LENGTH_LONG).show();
    }

    public void callFirst(View view) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}