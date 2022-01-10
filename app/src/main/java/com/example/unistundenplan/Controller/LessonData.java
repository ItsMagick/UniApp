package com.example.unistundenplan.Controller;

import android.os.Handler;
import android.os.Looper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import com.example.unistundenplan.Models.Course;
import com.example.unistundenplan.Models.Lesson;
import com.example.unistundenplan.Models.Semester;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LessonData {
    private static final ArrayList<Lesson> lessons = new ArrayList<>();
    private static final OkHttpClient client = new OkHttpClient();
    private static final Handler handler = new android.os.Handler(Looper.getMainLooper());
    private static final ExecutorService exe = Executors.newFixedThreadPool(2);

    public static void getLessons(Course course, Semester semester, Consumer<Optional<ArrayList<Lesson>>> lessonsCallback ){

        if(lessons.isEmpty()){
            Request request = new Request.Builder()
                    .url("https://www.hof-university.de/index.php?type=1421771406&id=79&tx_stundenplan_stundenplan[controller]=Ajax&tx_stundenplan_stundenplan[action]=loadVorlesungen&tx_stundenplan_stundenplan[studiengang]=" + course.getId() + "&tx_stundenplan_stundenplan[semester]=" + semester.getId() + "&tx_stundenplan_stundenplan[view]=wochen")
                    .build();

            exe.submit(() -> {
                try (Response response = client.newCall(request).execute()) {
                    parseLessons(response.body().string());
                    handler.post(() -> lessonsCallback.accept(Optional.of(lessons)));
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(() -> lessonsCallback.accept(Optional.empty()));
                }
            });
        } else {
            lessonsCallback.accept(Optional.of(lessons));
        }


    }


    public static void parseLessons(String url){
        Document doc = Jsoup.parse(url);
        Elements tables = doc.selectFirst("div[class = hide-for-small]").children();

        for (int i = 1; i < tables.size(); i++) { //first row is the empty col so skip it.
            String day = tables.get(i).selectFirst("th[colspan]").text();
            Elements rows = tables.get(i).selectFirst("tbody").select("tr");
            for(int j = 0; j < rows.size(); j++){
                Lesson lesson = new Lesson();
                lesson.setDay(day);

                Elements rowElements = rows.get(j).select("td[valign]");

                Elements nameAndInfo = rowElements.get(3).getAllElements();
                ArrayList<String> additionalInformation = new ArrayList<>();
                nameAndInfo.get(0).textNodes().forEach(node -> additionalInformation.add(node.text()));
                lesson.setName(additionalInformation.remove(0));
                lesson.setAdditionalInformation(additionalInformation);

                lesson.setBegin(rowElements.get(1).text());
                lesson.setEnd(rowElements.get(2).text());
                lesson.setProfessor(rowElements.get(4).text());
                lesson.setType(rowElements.get(5).text());
                lesson.setRoom(rowElements.get(6).text());

                lessons.add(lesson);

            }
        }
    }



}
