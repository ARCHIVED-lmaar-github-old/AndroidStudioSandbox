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

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRandomNumber.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRandomNumber#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRandomNumber extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_randomnumber, container, false);

        TextView x = view.findViewById(R.id.numberRandomAnswer);
        x.setText("000");

        // Button Listener
        final Button buttonRandom = view.findViewById(R.id.buttonRandom);
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tv_numberRandomMax = view.findViewById(R.id.numberRandomMax);
                TextView tv_numberRandomAnswer = view.findViewById(R.id.numberRandomAnswer);

                Random rand = new Random();

                if(tv_numberRandomMax.getText().length() > 7){
                    tv_numberRandomMax.setText("9999999");
                }

                Integer numberRandomMax = Integer.valueOf(String.valueOf(tv_numberRandomMax.getText()));

                String strnumberRandomAnswer = String.valueOf(rand.nextInt(numberRandomMax));

                tv_numberRandomAnswer.setText(strnumberRandomAnswer);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
