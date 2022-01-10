package com.example.unistundenplan;

import android.content.SharedPreferences;

import com.example.unistundenplan.Models.Course;
import com.example.unistundenplan.Models.Semester;

public class PersistentSettings {
    public static final String UNIAPP_SETTINGS = "sebs.uniapp";

    private static final String COURSE_ID = "course_ID";
    private static final String COURSE_NAME = "course_name";
    private static final String SEMESTER_ID = "semester_ID";
    private static final String SEMESTER_NAME = "semester_name";

    private final SharedPreferences sharedPreferences;


    public PersistentSettings(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    public Semester getSemester(){
        String id = sharedPreferences.getString(SEMESTER_ID, "");
        String name = sharedPreferences.getString(SEMESTER_NAME, "");
        return new Semester(id, name);
    }

    public void setSemester(Semester semester){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SEMESTER_ID, semester.getId());
        editor.putString(SEMESTER_NAME, semester.getName());
        editor.apply();
    }

    public Course getCourse(){
        String id = sharedPreferences.getString(COURSE_ID, "");
        String name = sharedPreferences.getString(COURSE_NAME, "");
        return new Course(id, name);
    }

    public void setCourse(Course course){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COURSE_ID, course.getId());
        editor.putString(COURSE_NAME, course.getCourseName());
        editor.apply();
    }

    public void resetSettings(){
        SharedPreferences.Editor editor = sharedPreferences.edit().clear();
        editor.apply();
    }

}
