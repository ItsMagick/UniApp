package com.example.unistundenplan.data;

import android.os.Handler;
import android.os.Looper;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LessonData {
    private static final ArrayList<Lesson> lessons = new ArrayList<>();
    private static final OkHttpClient client = new OkHttpClient();
    private static final Handler handler = new android.os.Handler(Looper.getMainLooper());
    private static final ExecutorService exe = Executors.newFixedThreadPool(2);

    public static void getLessons(Course course, Semester semester, Consumer<Optional<ArrayList<Lesson>>> lessonsCallback ){

        // Lesson Link raw
                                                        //https://www.hof-university.de/index.php?type=1421771406&id=79&tx_stundenplan_stundenplan[controller]=Ajax&tx_stundenplan_stundenplan[action]=loadVorlesungen&tx_stundenplan_stundenplan[studiengang]=MB&tx_stundenplan_stundenplan[semester]=1_WS_2021&tx_stundenplan_stundenplan[view]=alle&1639595091018=
        //org.jsoup.nodes.Element select = doc.selectFirst("https://www.hof-university.de/index.php?type=1421771406&id=79&tx_stundenplan_stundenplan[controller]=Ajax&tx_stundenplan_stundenplan[action]=loadVorlesungen&tx_stundenplan_stundenplan[studiengang]=" + course.getId() + "&tx_stundenplan_stundenplan[semester]=" + semester.getId() + "&tx_stundenplan_stundenplan[view]=wochen");
        //select.children().stream().filter(e -> !e.text().contains("wählen")).forEach(e -> lessons.add(new Lesson("hello")));

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
        //org.jsoup.nodes.Document doc = Jsoup.parse(url);
        //org.jsoup.nodes.Element select = doc.selectFirst("select[name=tx_stundenplan_stundenplan[studiengang]]");
        //select.children().stream().filter(e -> !e.text().contains("wählen")).forEach(e -> lessons.add(new Lesson("new Lesson"));
    }



}
