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



    public void onButtonRandomNumber(View view){
        TextView tv_numberRandomMax = findViewById(R.id.numberRandomMax);
        TextView tv_numberRandomAnswer = findViewById(R.id.numberRandomAnswer);

        Random rand = new Random();

        Integer numberRandomMax = Integer.valueOf(String.valueOf(tv_numberRandomMax.getText()));

        String strnumberRandomAnswer = String.valueOf(rand.nextInt(numberRandomMax));

        tv_numberRandomAnswer.setText(strnumberRandomAnswer);

        return;
    }


}
