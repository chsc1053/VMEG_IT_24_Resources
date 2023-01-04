package com.android_project.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private static final String[] names = {"Pink flower", "Yellow flower"};
    private static final int[] images = {R.drawable.pink_flower, R.drawable.yellow_flower};
    private int position = 0;
    private ImageSwitcher is;
    private TextSwitcher ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        is = (ImageSwitcher) findViewById(R.id.is);
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv = new ImageView(MainActivity.this);
                return iv;
            }
        });

        ts = (TextSwitcher) findViewById(R.id.ts);
        ts.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(MainActivity.this);
                tv.setGravity(Gravity.CENTER);
                return tv;
            }
        });
        ts.setInAnimation(this, android.R.anim.fade_in);
        ts.setOutAnimation(this, android.R.anim.fade_out);

        is.setInAnimation(this, android.R.anim.slide_in_left);
        is.setOutAnimation(this, android.R.anim.slide_out_right);
        onSwitch(null);
    }

    public void onSwitch(View view) {
        ts.setText(names[position]);
        is.setBackgroundResource(images[position]);
        position = (position + 1) % names.length;
    }
}