package com.example.unistundenplan.View.Schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unistundenplan.Models.Course;

import com.example.unistundenplan.R;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class ScheduleFragment extends Fragment {

    private ArrayList<Course> lessonsArrayList = new ArrayList<>();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        //recyclerView = view.findViewById(R.id.lesson_recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    /*
    public void loadLessons(){
        LessonData.getLessons(lessons ->{

        });
    }

     */
}