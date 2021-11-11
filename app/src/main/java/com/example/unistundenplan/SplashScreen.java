package com.example.unistundenplan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, TabbedActivity.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.finish();
        }, 3000);
    }
}