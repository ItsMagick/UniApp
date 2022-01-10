package com.example.unistundenplan.View.Init;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.unistundenplan.Models.Course;
import com.example.unistundenplan.Controller.CourseData;
import com.example.unistundenplan.PersistentSettings;
import com.example.unistundenplan.Models.Semester;
import com.example.unistundenplan.Controller.SemesterData;
import com.example.unistundenplan.R;
import com.example.unistundenplan.View.Schedule.ScheduleTabbedActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class SettingsFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<Course> coursesArrayList = new ArrayList<>();
    private ArrayList<Semester> semestersArrayList = new ArrayList<>();


    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /*
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCourseSpinnerSelectListener();
        loadCourses();
        Button submit = getView().findViewById(R.id.save_changes);
        submit.setOnClickListener(listener ->{
            submitChanges();
        });
    }


    public void loadCourses() {
        CourseData.getCourses(courses -> {
            if (courses.isPresent()) {
                Spinner courseSpinner = getView().findViewById(R.id.courses);
                String[] strings = courses.get().stream()
                        .map(Course::toString)
                        .collect(Collectors.toList()).toArray(new String[courses.get().size()]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, strings);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                courseSpinner.setAdapter(adapter);

                this.coursesArrayList = courses.get();
            }
        });
    }
    public void loadSemesters(Course course) {
        SemesterData.getSemesters(course, semesters -> {
            if (semesters.isPresent()) {
                Spinner semesterSpinner = getView().findViewById(R.id.semesters);
                String[] strings = semesters.get().stream()
                        .map(Semester::toString)
                        .collect(Collectors.toList()).toArray(new String[semesters.get().size()]);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, strings);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                semesterSpinner.setAdapter(adapter);

                this.semestersArrayList = semesters.get();
            }
        });
    }

    private void setCourseSpinnerSelectListener() {
        Spinner spinner = getView().findViewById(R.id.courses);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadSemesters(coursesArrayList.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void submitChanges() {
        Course course = coursesArrayList.get(((Spinner) getView().findViewById(R.id.courses)).getSelectedItemPosition());
        Semester semester = semestersArrayList.get(((Spinner) getView().findViewById(R.id.semesters)).getSelectedItemPosition());

        PersistentSettings settings = new PersistentSettings(getActivity().getSharedPreferences(PersistentSettings.SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE));

        settings.setCourse(course);
        settings.setSemester(semester);

        startActivity(new Intent().setClass(getActivity().getApplicationContext(), ScheduleTabbedActivity.class));
        getActivity().finish();
    }
}