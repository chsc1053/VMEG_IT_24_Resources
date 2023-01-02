package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.num1);
        t2 = findViewById(R.id.num2);
    }
    public void add(View view) {
        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString()), res = a+b;

        Toast.makeText(getApplicationContext(), a + " + " + b + " = " + res, Toast.LENGTH_LONG).show();
    }
    public void sub(View view) {
        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString()), res = a-b;

        Toast.makeText(getApplicationContext(), a + " - " + b + " = " + res, Toast.LENGTH_LONG).show();
    }
    public void mul(View view) {
        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString()), res = a*b;

        Toast.makeText(getApplicationContext(), a + " * " + b + " = " + res, Toast.LENGTH_LONG).show();
    }
    public void div(View view) {
        float a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString()), res = a/b;

        Toast.makeText(getApplicationContext(), a + " / " + b + " = " + res, Toast.LENGTH_LONG).show();
    }
    public void modulo(View view) {
        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString()), res = a%b;

        Toast.makeText(getApplicationContext(), a + " % " + b + " = " + res, Toast.LENGTH_LONG).show();
    }
}