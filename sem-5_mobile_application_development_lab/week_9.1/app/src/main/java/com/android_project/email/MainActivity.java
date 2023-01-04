package com.android_project.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_to, et_subject, et_message;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_to =(EditText)findViewById(R.id.recipient);
        et_subject =(EditText)findViewById(R.id.subject);
        et_message =(EditText)findViewById(R.id.message);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String re= et_to.getText().toString().trim();
                String su= et_subject.getText().toString().trim();
                String me= et_message.getText().toString().trim();
                sendEmail(re,su,me);
            }
        });
    }
    private void sendEmail(String re, String su, String me) {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("Mail to"));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{re});
        i.putExtra(Intent.EXTRA_SUBJECT,su);
        i.putExtra(Intent.EXTRA_TEXT,me);
        try{
            startActivity(Intent.createChooser(i, "choose an email client"));
        }
        catch(Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}