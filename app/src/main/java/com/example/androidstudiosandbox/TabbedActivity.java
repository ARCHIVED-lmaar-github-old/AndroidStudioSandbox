/*
 * Android Studio Demo
 * -----
 * This is a demo which shows basic Android functionality such as having multiple Activities and
 * a Tabbed Activity composed of multiple fragments.
 *
 * Each fragment has some kind of unique functionality - Random Number Generator, Sevice Generation,
 * Mock Video Game Battle, etc.
 * -----
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 * laurencemaar@gmail.com
 */

package com.example.androidstudiosandbox;

import android.os.Bundle;

import com.example.androidstudiosandbox.ui.main.SectionsPagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class TabbedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);


        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // FAB - Email
        final FloatingActionButton fab_email = findViewById(R.id.fab_email);

        fab_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "laurencemaar@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // FAB - Exit
        final FloatingActionButton fab_exit = findViewById(R.id.fab_exit);

        fab_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
