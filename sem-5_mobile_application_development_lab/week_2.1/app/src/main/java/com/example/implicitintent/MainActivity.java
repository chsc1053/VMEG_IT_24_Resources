package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.go_button);
        et = findViewById(R.id.tf);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(text));
                startActivity(i);
            }
        });
    }
}