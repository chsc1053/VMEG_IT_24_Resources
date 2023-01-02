package com.example.spinnner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String countries[] = {"Australia", "Bulgaria", "China", "Denmark", "India"};
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), countries[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}