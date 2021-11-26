package com.example.unistundenplan.data;

import android.os.Looper;
import android.os.Handler;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CourseData {
    private static final ArrayList<String> coursesOut = new ArrayList<>();
    private static final ArrayList<Course> toCourses = new ArrayList<>();

    private static final OkHttpClient client = new OkHttpClient();
    private static final ExecutorService exe = Executors.newFixedThreadPool(2);
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static ArrayList <String> parseCourses(String url){

        try{
            org.jsoup.nodes.Document doc = Jsoup.parse(url);
            org.jsoup.nodes.Element select = doc.selectFirst("select[name=tx_stundenplan[studiengang]]");

            for(org.jsoup.nodes.Element element : select.children()){
                if(!element.text().contains("wählen")) {
                    toCourses.add(new Course(element.val(), element.text()));
                }
            }

        }catch (Exception e){
        }
        return coursesOut;
    }

    public static void getCourses(Consumer<Optional<ArrayList<Course>>> coursesCallback) {
        if (coursesOut.isEmpty()) {
            Request request = new Request.Builder()
                    .url("https://hof-university.de/studierende/info-service/stundenplaene/")
                    .build();

            exe.submit(() -> {
                try (Response response = client.newCall(request).execute()) {
                    parseCourses(response.body().string());
                    handler.post(() -> coursesCallback.accept(Optional.of(toCourses)));
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(() -> coursesCallback.accept(Optional.empty()));
                }
            });
        } else {
            coursesCallback.accept(Optional.of(toCourses));
        }
    }

}
