package com.example.icms;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Splash_Screen extends AppCompatActivity {
    private static final int SPLASH_SCREEN = 3000;
    Animation left, right;
    TextView splash_txt, splash_txt2;
    ImageView splash_img;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.primarytheme1));
        }
        left = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);

        splash_img = findViewById(R.id.splash_img);
        splash_txt = findViewById(R.id.splash_txt);
        splash_txt2 = findViewById(R.id.splash_txt2);

        //start animation
        splash_img.setAnimation(left);
        splash_txt.setAnimation(right);
        splash_txt2.setAnimation(right);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Signup.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}