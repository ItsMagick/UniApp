package com.example.unistundenplan.data;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Optional;

public class CourseData {


    public ArrayList <String> parseCourses(String studiengaengeEx){
        final ArrayList<String> studiengaenge = new ArrayList<>();

        try{
            org.jsoup.nodes.Document doc = Jsoup.parse(studiengaengeEx);
            org.jsoup.nodes.Element select = doc.selectFirst("select[name=tx_stundenplan[studiengang]]");

            for(org.jsoup.nodes.Element element : select.children()){
                if(!element.text().contains("wählen"))
                    studiengaenge.add(element.text());
                System.out.println(studiengaenge.add(element.text()));
            }

        }catch (Exception e){

        }
        return studiengaenge;
    }

    public static void getCourses(){

    }
}
