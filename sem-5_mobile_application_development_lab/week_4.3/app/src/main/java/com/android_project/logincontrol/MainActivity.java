package com.android_project.logincontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText et_uname, et_pwd;
    String uname = "sai", pwd = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.b);
        et_uname = (EditText) findViewById(R.id.et_uname);
        et_pwd = (EditText) findViewById(R.id.et_pwd);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_uname = et_uname.getText().toString();
                String input_pwd = et_pwd.getText().toString();

                if(input_uname.equals(uname) && input_pwd.equals(pwd)){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}