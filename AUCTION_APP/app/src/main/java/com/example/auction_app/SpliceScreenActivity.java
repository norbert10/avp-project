package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SpliceScreenActivity extends AppCompatActivity {

    //variable for time, using capital letter because it is static
    private static  int SPLASH_SCREEN = 5000;

    //variables
    Animation topAnimation, bottomAnimation;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splice_screen);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hide action bar
        getSupportActionBar().hide();

        //Animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.imageView);
        title = findViewById(R.id.titleText);

        //set Animation
        title.setAnimation(topAnimation);
        image.setAnimation(bottomAnimation);

        //create a splash screen, call Intent inside delay() method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SpliceScreenActivity.this, MainActivity.class);
                startActivity(splash);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}