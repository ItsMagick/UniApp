package com.example.unistundenplan.ui.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.unistundenplan.R;
import com.example.unistundenplan.View.Schedule.ScheduleChanges;
import com.example.unistundenplan.View.Schedule.ScheduleFragment;
import com.example.unistundenplan.View.Init.SettingsFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the tabs
 */
public class TimetableTabsAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_schedule, R.string.tab_changes, R.string.tab_settings};
    private final Context mContext;

    public TimetableTabsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new ScheduleFragment();
                break;
            case 1:
                fragment = new ScheduleChanges();
                break;
            case 2:
                fragment = new SettingsFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}