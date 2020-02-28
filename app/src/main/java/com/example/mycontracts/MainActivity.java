package com.example.mycontracts;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1Tv, textView2Tv;
    private ImageView imageView;

    SharedPreferences sharedPreferences;
    Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.welcome_Img);
        textView1Tv = findViewById(R.id.textView1);
        textView2Tv = findViewById(R.id.textView2);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);

        imageView.startAnimation(animation);
        textView1Tv.startAnimation(animation);
        textView2Tv.startAnimation(animation);

        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        firstTime = sharedPreferences.getBoolean("firstTime",true);

        if (firstTime){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime",firstTime);
                    editor.apply();
                     startActivity(new Intent(MainActivity.this,MainHomeActivity.class));
                    finish();

                }
            }, 5000);
        }else {
             startActivity(new Intent(MainActivity.this,MainHomeActivity.class));
            finish();
        }

    }
}
