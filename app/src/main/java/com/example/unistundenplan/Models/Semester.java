package com.example.unistundenplan.Models;

public class Semester {
    private final String id;
    private final String semesterName;

    public Semester(String id, String semesterName) {
        this.id = id.replace("#", "_");
        this.semesterName = semesterName;
    }

    public String getName() {
        return semesterName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return semesterName;
    }
}
