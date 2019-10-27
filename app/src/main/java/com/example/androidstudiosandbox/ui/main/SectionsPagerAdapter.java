package com.example.androidstudiosandbox.ui.main;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidstudiosandbox.FragmentRandomNumber;
import com.example.androidstudiosandbox.BlankFragment2;
import com.example.androidstudiosandbox.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
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

                FragmentRandomNumber bf1 = new FragmentRandomNumber();
                return bf1;

                // Return a PlaceholderFragment (defined as a static inner class below).
                //return PlaceholderFragment.newInstance(position + 1);
            case 1:
                //Toast.makeText(mContext, "TAB 2", Toast.LENGTH_SHORT).show();

                BlankFragment2 bf2 = new BlankFragment2();
                return bf2;
            default:
                // Return a PlaceholderFragment (defined as a static inner class below).
                return PlaceholderFragment.newInstance(position + 1);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}