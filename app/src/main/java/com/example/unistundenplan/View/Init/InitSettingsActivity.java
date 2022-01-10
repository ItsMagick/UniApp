package com.example.unistundenplan.View.Init;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unistundenplan.R;


//A class for the initial setup dialogue to set your contents up for e.g. schedules


public class InitSettingsActivity extends AppCompatActivity {

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