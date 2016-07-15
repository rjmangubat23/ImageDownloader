package com.mindvalley.com.mindvalley_reuben_android_test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindvalley.com.mindvalley_reuben_android_test.R;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class SplashActivity extends AppCompatActivity {

    private Intent intent;
    private ImageView app_logo;
    private  Handler splashHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        app_logo = (ImageView) findViewById(R.id.imageView_logo);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        YoYo.with(Techniques.FadeIn)
                .duration(800)
                .playOn(app_logo);

        splashHandler = new Handler();
        splashHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.transition.push_down_in, R.transition.push_down_out);
                    finish();

            }
        }, 2500);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(splashHandler != null){
            splashHandler = null;
        }
    }
}
