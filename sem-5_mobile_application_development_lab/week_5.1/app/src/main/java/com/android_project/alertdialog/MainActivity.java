package com.android_project.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    AlertDialog.Builder ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.b);
        ad = new AlertDialog.Builder(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setMessage("Do you really want to close the application?");
                ad.setCancelable(true);
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog a = ad.create();
                a.setTitle("Alert");
                a.show();
            }
        });
    }
}