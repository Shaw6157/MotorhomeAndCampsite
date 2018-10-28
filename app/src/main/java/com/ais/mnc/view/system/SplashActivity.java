package com.ais.mnc.view.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.ais.mnc.R;
import com.ais.mnc.util.MncUtilities;

public class SplashActivity extends AppCompatActivity {
    ImageView img_logo;
    TextView tv_slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        img_logo = findViewById(R.id.img_logo);
        tv_slogan = findViewById(R.id.tv_slogan);

        //TODO multi thread to init DB
        //......

        initSplashAnimation();
    }

    private void initSplashAnimation() {
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(500);
        alpha.setFillAfter(true);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MncUtilities.startNextActivity(SplashActivity.this, UserLoginActivity.class, true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        img_logo.setAnimation(alpha);
        tv_slogan.setAnimation(alpha);
    }
}
