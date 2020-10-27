package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView easier;

        easier = findViewById(R.id.easier);


        //Text Animation

        easier.setAlpha((float) 0.0);
        easier.setTranslationY(20);

        easier.animate().alpha((float) 1.0).setDuration(800).setStartDelay(250);
        easier.animate().translationY(0).setDuration(400).setStartDelay(250);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(1300);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(),
                            SplashScreen.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // start thread
        background.start();
    }
}