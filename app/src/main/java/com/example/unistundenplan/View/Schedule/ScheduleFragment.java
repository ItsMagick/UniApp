package com.example.unistundenplan.View.Schedule;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.unistundenplan.Models.Course;

import com.example.unistundenplan.Models.Lesson;
import com.example.unistundenplan.R;
import com.example.unistundenplan.View.LessonDetails.DetailsTabbedActivity;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {



    private ArrayList<Lesson> lessonsArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    public ScheduleFragment() {
    }


    @SuppressWarnings("unused")
    public static ScheduleFragment newInstance(int columnCount) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void showDetails() {
        startActivity(new Intent().setClass(getActivity().getApplicationContext(), DetailsTabbedActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        //recyclerView = view.findViewById(R.id.lesson_recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webview = getActivity().findViewById(R.id.schedule_webview);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://www.hof-university.de/studierende/info-service/stundenplaene.html");
        Button details = getView().findViewById(R.id.switchToDetails);
        details.setOnClickListener( e -> {
            showDetails();
        });
    }

    /*
    public void loadLessons(){
        LessonData.getLessons(lessons ->{

        });
    }

     */
}