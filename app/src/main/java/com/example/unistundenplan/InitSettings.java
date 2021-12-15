package com.example.unistundenplan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.unistundenplan.data.Course;
import com.example.unistundenplan.data.CourseData;
import com.example.unistundenplan.data.SemesterData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//A class for the initial setup dialogue to set your contents up for e.g. schedules


public class InitSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if(isFirstTime()) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        setContentView(R.layout.activity_init_settings);
        //}
       //so that you cannot navigate back to the activity after you have set the initial settings.
        //Button commit = findViewById(R.id.save_changes);
        //courseSpinner = findViewById(R.id.courses);
        //courseSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        //ArrayAdapter<Course> arrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_spinner_dropdown_item, courses);
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //courseSpinner.setAdapter(arrayAdapter);



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