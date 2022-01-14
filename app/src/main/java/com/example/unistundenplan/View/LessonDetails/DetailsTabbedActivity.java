package com.example.unistundenplan.View.LessonDetails;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unistundenplan.Adapter.LessonDetailsTabAdapter;
import com.example.unistundenplan.databinding.ActivityDetailsTabbedBinding;

public class DetailsTabbedActivity extends AppCompatActivity {

    private ActivityDetailsTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LessonDetailsTabAdapter sectionsPagerAdapter = new LessonDetailsTabAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}

