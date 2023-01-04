package com.android_project.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.phone);
        et2=findViewById(R.id.message);
        b=findViewById(R.id.send);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                    sendMessage();
                else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
            }
        });
    }
    public void sendMessage() {
        String mobile = et1.getText().toString().trim();
        String sms = et2.getText().toString().trim();
        if((!mobile.equals(""))&&(!sms.equals("")))
        {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(mobile,null,sms,null,null);
            Toast.makeText(this, "Message sent successfully", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Enter Mobile Number and Message",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100&&grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
            sendMessage();
        else
            Toast.makeText(getApplicationContext(),"permission denied",Toast.LENGTH_SHORT).show();
    }
}