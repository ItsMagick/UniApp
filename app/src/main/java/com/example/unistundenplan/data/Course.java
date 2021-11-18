package com.example.unistundenplan.data;

public class Course {
    private final String id;
    private final String displayName;

    public Course(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
