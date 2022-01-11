package com.example.unistundenplan.ui.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.unistundenplan.R;
import com.example.unistundenplan.View.Init.SettingsFragment;
import com.example.unistundenplan.View.LessonDetails.ChatFragment;
import com.example.unistundenplan.View.LessonDetails.ModuleHandbookFragment;
import com.example.unistundenplan.View.LessonDetails.NotesFragment;
import com.example.unistundenplan.View.LessonDetails.ProfessorDetailsFragment;
import com.example.unistundenplan.View.Schedule.ScheduleChanges;
import com.example.unistundenplan.View.Schedule.ScheduleFragment;

public class LessonDetailsTabAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_module_book,R.string.tab_professor, R.string.tab_notes, R.string.tab_chat};
    private final Context mContext;

    public LessonDetailsTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

   @Override
    public Fragment getItem(int position) {

       Fragment fragment = null;

       switch (position){
           case 0:
               fragment = new ModuleHandbookFragment();
               break;
           case 1:
               fragment = new ProfessorDetailsFragment();
               break;
           case 2:
               fragment = new NotesFragment();
               break;
           case 3:
               fragment = new ChatFragment();
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
        return 4;
    }
}
