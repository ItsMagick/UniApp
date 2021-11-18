package com.example.unistundenplan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.unistundenplan.data.Course;
import com.example.unistundenplan.data.SemesterData;

import java.util.ArrayList;
import java.util.stream.Collectors;


//A class for the initial setup dialogue to set your contents up for e.g. schedules


public class InitSettings extends AppCompatActivity {

    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if(isFirstTime()) {
        setContentView(R.layout.activity_init_settings);
        //}
       //so that you cannot navigate back to the activity after you have set the initial settings.
        Button commit = findViewById(R.id.save_changes);

    }

    public void commitChanges(View view) {

        new Handler().post(() ->{
            Intent intent = new Intent(InitSettings.this, TabbedActivity.class);
            InitSettings.this.startActivity(intent);
            InitSettings.this.finish();
        });
    }



   /* private boolean isFirstTime(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);

        if(!ranBefore){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }


    */
   }