package com.example.androidstudiosandbox;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBattle.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBattle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBattle extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_battle, container, false);

        // Button Listener
        final Button buttonAttack = view.findViewById(R.id.buttonAttack);
        buttonAttack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here


                setProgressBar( view,generateRandom(25,5)*-1);

                /*
                final ProgressBar tv = view.findViewById(R.id.progressBar);
                //tv.setProgress(10);
                tv.setSecondaryProgress(tv.getProgress());
                tv.incrementProgressBy(generateRandom(25,1)*-1);
                //tv.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        tv.incrementProgressBy(generateRandom(25,1)*-1);
                    }
                }, 200);

                 */

            }
        });

        // Button Listener
        final Button buttonHeal = view.findViewById(R.id.buttonHeal);
        buttonHeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here

                setProgressBar( view,generateRandom(25,5));

                /*
                final ProgressBar tv = view.findViewById(R.id.progressBar);
                //tv.setProgress(85);
                tv.setSecondaryProgress(tv.getProgress());
                tv.incrementProgressBy(generateRandom(25,1));
                //tv.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                */

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    int generateRandom(int Max, int Min)
    {
        Random rand = new Random();

        return rand.nextInt(Max) + Min;
    }

    public void setProgressBar(View view, final int Progress)
    {
        final ProgressBar tv = view.findViewById(R.id.progressBar);
        //tv.setProgress(10);
        tv.setSecondaryProgress(tv.getProgress());
        //tv.incrementProgressBy(Progress);
        //tv.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        if(Progress>0)
        {
            for(int x=0;x<(Progress);x++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        tv.incrementProgressBy(1);
                    }
                }, 4*x);
            }
        }
        else
        {
            for(int x=0;x<(Progress*-1);x++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        tv.incrementProgressBy(-1);
                    }
                }, 5*x);
            }

            for(int x=0;x<(Progress*-1);x++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        tv.incrementSecondaryProgressBy(-1);
                    }
                }, 10*Progress*-1+5*x+100);
            }
            /*
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    tv.setSecondaryProgress(tv.getProgress());
                }
            }, );
            */
        }

    }


}
