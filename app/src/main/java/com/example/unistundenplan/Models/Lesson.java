package com.example.unistundenplan.Models;

import java.util.ArrayList;

public class Lesson {


    private String day;
    private String name;
    private String date;
    private String professor;
    private String type;
    private String room;
    private String additionalInformation;

    public String getName() { return name; }

    public void setName(String name){this.name = name;}

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getProfessor() { return professor; }

    public void setProfessor(String professor) { this.professor = professor; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public String getDay() { return day; }

    public void setDay(String day) { this.day = day; }

    public String toString(){
        return "Lesson(" +
                ", day='" + day + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", lecturer='" + professor + '\'' +
                ", type='" + type + '\'' +
                ", room='" + room + '\'' +
                ", additionalInformation=" + additionalInformation +
                ')';
    }

    public void setBegin(String text) {
    }

    public void setEnd(String text) {
    }

    public void setAdditionalInformation(ArrayList<String> additionalInformation) {
    }
}
