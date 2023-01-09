package com.android_project.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv;
        Button b_fadein,b_slidedown;
        b_fadein = (Button) findViewById(R.id.b_fadein);
        b_slidedown = (Button) findViewById(R.id.b_slidedown);
        iv = (ImageView) findViewById(R.id.iv);

        b_fadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation a_fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_fade_in);
                iv.startAnimation(a_fadein);
            }
        });

        b_slidedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation a_slidedown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_slide_down);
                iv.startAnimation(a_slidedown);
            }
        });

    }
}