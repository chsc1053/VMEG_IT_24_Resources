package com.android_project.progressbarseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    Handler handler = new Handler();
    ProgressBar pb;
    SeekBar sb;
    TextView tv,tv2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.pb);
        tv = (TextView) findViewById(R.id.tv);
        Button b = (Button) findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = pb.getProgress();
                new Thread(new Runnable() {
                    public void run() {
                        while (i < 100) {
                            i += 1;
                            // Update the progress bar and display the current value in text view
                            handler.post(new Runnable() {
                                public void run() {
                                    pb.setProgress(i);
                                    tv.setText(i+"/"+pb.getMax());
                                }
                            });
                            try {
                                // Sleep for 100 milliseconds to show the progress slowly.
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        sb = (SeekBar) findViewById(R.id.sb);
        tv2 = (TextView) findViewById(R.id.tv2);

        tv.setText(sb.getProgress() + "/" + sb.getMax());
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv2.setText(p + "/" + seekBar.getMax());
            }
        });
    }
}