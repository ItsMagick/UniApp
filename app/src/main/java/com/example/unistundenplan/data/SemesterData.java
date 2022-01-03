package com.example.unistundenplan.data;

import android.os.Handler;
import android.os.Looper;

import org.jsoup.Jsoup;

import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import Models.Course;
import Models.Semester;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SemesterData {

    private static final ArrayList<Course> toCourses = new ArrayList<>();
    private static final HashMap<String, ArrayList<Semester>> semesters = new HashMap<>();
    private static final OkHttpClient client = new OkHttpClient();
    private static final ExecutorService exe = Executors.newFixedThreadPool(2);
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void getSemesters(Course course, Consumer<Optional<ArrayList<Semester>>> semestersCallback){
        if (!semesters.containsKey(course.getId())) {

            Request request = new Request.Builder()
                    .url("https://www.hof-university.de/index.php?type=1421771406&id=79&tx_stundenplan_stundenplan[controller]=Ajax&tx_stundenplan_stundenplan[action]=loadSemester&tx_stundenplan_stundenplan[studiengang]=" + course.getId())
                    .build();


            exe.submit(() -> {
                try (Response response = client.newCall(request).execute()) {
                    parseSemester(course, response.body().string());

                    handler.post(() -> semestersCallback.accept(Optional.of(semesters.get(course.getId()))));
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(() -> semestersCallback.accept(Optional.empty()));
                }
            });
        } else {
            semestersCallback.accept(Optional.of(semesters.get(course.getId())));
        }

    }
    private static void parseSemester(Course course, String body) {
        semesters.put(course.getId(), new ArrayList<>());
        String semesterHtml = JsonParser.parseString(body).getAsJsonObject().get("semester").getAsString();
        org.jsoup.nodes.Document document = Jsoup.parse(semesterHtml);
        org.jsoup.nodes.Element select = document.selectFirst("select[id=semesterSelect]");
        select.children().stream().filter(e -> !e.text().contains("wählen")).forEach(e -> semesters.get(course.getId()).add(new Semester(e.val(), e.text())));
    }
}
