package com.gralliams.fitnessstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
private ImageView pointer;
private Button startButton;
    private Button stopButton;
    private Chronometer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        pointer = findViewById(R.id.pointer);
        startButton = findViewById(R.id.start_btn);
        stopButton = findViewById(R.id.btn_finish);
        //Sets alpha transition == 0 i.e = invisible
        stopButton.setAlpha(0);
        initButton();
    }

    private void initButton() {
    startButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf"));
    stopButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf"));
    startButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            pointer.startAnimation(AnimationUtils.loadAnimation(StopWatchActivity.this, R.anim.round_anim));
            //Make stop button visible and translate upward
            stopButton.animate().alpha(1).translationY(-130).setDuration(300).start();
            //Make start button invisible
            startButton.animate().alpha(0).setDuration(300).start();
            //Start timer
            mTimer = findViewById(R.id.timer);
            mTimer.setBase(SystemClock.elapsedRealtime());
            mTimer.start();

        }
    });

    stopButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        //Refreshes this activity
            finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
            overridePendingTransition(0, 0);
        }

    });
    }
}