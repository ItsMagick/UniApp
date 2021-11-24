package com.example.unistundenplan.data;

import org.jsoup.Jsoup;

import java.util.ArrayList;

public class CourseData {
    final ArrayList<String> coursesOut = new ArrayList<>();
    final ArrayList<Course> toCourses = new ArrayList<>();

    public ArrayList <String> parseCourses(String url){

        try{
            org.jsoup.nodes.Document doc = Jsoup.parse(url);
            org.jsoup.nodes.Element select = doc.selectFirst("select[name=tx_stundenplan[studiengang]]");

            for(org.jsoup.nodes.Element element : select.children()){
                if(!element.text().contains("wählen")) {
                    coursesOut.add(element.text());
                    Course course = new Course(element.id(), element.text());
                    toCourses.add(course);
                }
            }

        }catch (Exception e){

        }
        return coursesOut;
    }

    public static void getCourses(){

    }

}
