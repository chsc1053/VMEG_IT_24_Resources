package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = null;
    }
    public void music(View v) {
        switch (v.getId()) {
            case R.id.b_play:
                if (mp == null)
                    mp = MediaPlayer.create(this, R.raw.song);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });
                mp.start();
                break;
            case R.id.b_pause:
                if (mp != null)
                    mp.pause();
                break;
            case R.id.b_stop:
                if (mp != null) {
                    mp.stop();
                    stopMusic();
                }
                break;
        }
    }
    public void stopMusic() {
        mp.release();
        mp = null;
    }
    public void onStop() {
        super.onStop();
        stopMusic();
    }
}