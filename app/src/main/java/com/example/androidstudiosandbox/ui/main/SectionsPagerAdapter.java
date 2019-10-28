package com.example.androidstudiosandbox.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidstudiosandbox.FragmentBattle;
import com.example.androidstudiosandbox.FragmentRandomNumber;
import com.example.androidstudiosandbox.BlankFragment;
import com.example.androidstudiosandbox.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.

        switch(position) {
            case 0:
                //Toast.makeText(mContext, "TAB 1", Toast.LENGTH_SHORT).show();
                return new FragmentRandomNumber();
            case 1:
                //Toast.makeText(mContext, "TAB 2", Toast.LENGTH_SHORT).show();
                return new FragmentBattle();
            default:
                return new BlankFragment();

                // Return a PlaceholderFragment (defined as a static inner class below).
                //return PlaceholderFragment.newInstance(position + 1);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show number of tabs.
        return 3;
    }
}