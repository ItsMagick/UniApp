package com.example.unistundenplan.View.Schedule;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.unistundenplan.databinding.ActivityTabbedBinding;
import com.example.unistundenplan.ui.Adapter.DetailsToLessonTabsAdapter;
import com.google.android.material.tabs.TabLayout;

public class ScheduleTabbedActivity extends AppCompatActivity {

    private ActivityTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DetailsToLessonTabsAdapter detailsToLessonTabsAdapter = new DetailsToLessonTabsAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(detailsToLessonTabsAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}