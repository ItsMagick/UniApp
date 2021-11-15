package com.example.unistundenplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


//A class for the initial setup dialogue to set your contents up for e.g. schedules


public class InitSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isFristTime()) {
            setContentView(R.layout.activity_init_settings);
        }
        finish(); //so that you cannot navigate back to the activity after you have set the initial settings.
    }

    private boolean isFristTime(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);

        if(!ranBefore){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }


}