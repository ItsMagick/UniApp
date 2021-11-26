package com.example.unistundenplan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.unistundenplan.data.Course;
import com.example.unistundenplan.data.CourseData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<Course> coursesArrayList = new ArrayList<>();

    private String mParam1;
    private String mParam2;
    private Spinner spinner;

    public SettingsFragment() {
        // Required empty public constructor

    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            //spinner = getView().findViewById(R.id.courses);
            //ArrayList courses = CourseData.getCourses();
            //ArrayAdapter <Course> adapter = new ArrayAdapter<Course>(this,);


        }

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCourses();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_settings2, container, false);
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
            } else {
                //showErrorAlert();
            }
        });

    }
}