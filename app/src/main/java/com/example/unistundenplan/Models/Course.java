package com.example.unistundenplan.Models;

public class Course {
    private final String id;
    private final String courseName;

    public Course(String id, String displayName) {
        this.id = id;
        this.courseName = displayName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getCourseName();
    }
}
