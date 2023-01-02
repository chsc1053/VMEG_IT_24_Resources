package com.example.hellosai;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "My APP has created.");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "My APP has started.");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag", "My APP has restarted.");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "My APP has paused.");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "My APP has resumed.");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "My APP has destroyed.");
    }
}