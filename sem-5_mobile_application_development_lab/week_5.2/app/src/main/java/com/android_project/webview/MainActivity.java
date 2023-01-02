package com.android_project.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.wv);
        String data = "<html> <body bgcolor='lavender'> <h1> Hello World </h1> </body> </html>";
        wv.loadData(data, "text/html", "utf-8");
    }
}