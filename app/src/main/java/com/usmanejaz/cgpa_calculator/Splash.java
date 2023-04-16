package com.usmanejaz.cgpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import android.os.*;

public class Splash extends AppCompatActivity {

    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        animate();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {


                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }



        }, 5000);



    }

    public void animate(){
        logo = findViewById(R.id.logo);
        Animation move = AnimationUtils.loadAnimation(this, R.anim.animation_splash);

        logo.startAnimation(move);

    }
}