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

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentServices.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentServices#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentServices extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_services, container, false);

        // Button Listener
        final Button buttonAttack = view.findViewById(R.id.buttonStart);
        buttonAttack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(view);
            }
        });

        // Button Listener
        final Button buttonHeal = view.findViewById(R.id.buttonStop);
        buttonHeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopService(view);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


    // Service - Start
    public void startService(View view) {
        // startService(new Intent(getBaseContext(), MyService.class));
        getActivity().startService(new Intent(getActivity(), MyService.class));
    }

    // Service - Stop
    public void stopService(View view) {
        // stopService(new Intent(getBaseContext(), MyService.class));
        getActivity().stopService(new Intent(getActivity(), MyService.class));
    }



}
