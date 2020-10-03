package com.gralliams.fitnessstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mSplashImage;
    private TextView mSplashTitle;
    private TextView mSplashSubtitle;
    private Button mGetStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSplashImage = findViewById(R.id.splash_img);
        mSplashTitle = findViewById(R.id.splash_header);
        mSplashSubtitle = findViewById(R.id.splash_subtitle);
        mGetStartedBtn = findViewById(R.id.start_btn);

        mGetStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });


        setDefaultFont();
        setAnimation();

    }

    private void setAnimation() {
        Animation alphaAnimation = AnimationUtils.loadAnimation(this,  R.anim.alpha_to_go);
        mSplashImage.startAnimation(alphaAnimation);
        mSplashTitle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_one));
        mSplashSubtitle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_one));
        mGetStartedBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_two));
    }

    private void setDefaultFont() {

        //Customise font
        mSplashTitle.setTypeface( Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf"));
        mSplashSubtitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf"));
        mGetStartedBtn.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf"));
    }
}