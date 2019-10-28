package com.example.androidstudiosandbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBattlev2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBattlev2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBattlev2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_battle_v2, container, false);

        // Button Listener
        final Button buttonAttack = view.findViewById(R.id.buttonAttack);
        buttonAttack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                gameAttack( view,generateRandom(30,10)*-1, R.id.myEnemyHealth, R.id.myEnemyShields);
                gameAttack( view,generateRandom(6,2)*-1, R.id.myPlayerHealth, R.id.myPlayerShields);

            }
        });

        // Button Listener
        final Button buttonHeal = view.findViewById(R.id.buttonHeal);
        buttonHeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                gameHeal( view,generateRandom(25,5), R.id.myPlayerHealth, R.id.myPlayerShields);

            }
        });

        // Button Listener
        final Button buttonReset = view.findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                gameReset( view, R.id.myEnemyHealth, R.id.myEnemyShields );
                gameReset( view, R.id.myPlayerHealth, R.id.myPlayerShields );
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


    int generateRandom(int Max, int Min)
    {
        Random rand = new Random();

        return rand.nextInt(Max) + Min;
    }


    public void gameReset(View view, final int Health, final int Shields)
    {
        final ProgressBar HealthBar = view.findViewById(Health);
        final ProgressBar ShieldBar = view.findViewById(Shields);

        HealthBar.setProgress(100);
        HealthBar.setSecondaryProgress(100);

        ShieldBar.setProgress(50);
        ShieldBar.setSecondaryProgress(50);

        // Toast
        Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();
    }




    public void gameCheckEnemyHealth(View view) {
        final ProgressBar HealthBar = view.findViewById(R.id.myEnemyHealth);
        final ProgressBar ShieldBar = view.findViewById(R.id.myEnemyShields);

        if(HealthBar.getProgress() < 5)
        {
            // Reset Enemy
            HealthBar.setProgress(100);
            HealthBar.setSecondaryProgress(100);

            ShieldBar.setProgress(50);
            ShieldBar.setSecondaryProgress(50);

            // Give XP
            final ProgressBar PlayerXP = view.findViewById(R.id.myPlayerXP);
            PlayerXP.incrementProgressBy(generateRandom(10,5));

            // Update XP
            final TextView helloTextView = view.findViewById(R.id.textPlayerXP);
            helloTextView.setText(String.format("XP: %d / %d", PlayerXP.getProgress(), PlayerXP.getMax()));
        }
    }


    public void gameAttack(final View view, final int Amount, final int Health, final int Shields)
    {
        //final ProgressBar HealthBar = view.findViewById(R.id.myEnemyHealth);
        //final ProgressBar ShieldBar = view.findViewById(R.id.myEnemyShields);
        final ProgressBar HealthBar = view.findViewById(Health);
        final ProgressBar ShieldBar = view.findViewById(Shields);

        HealthBar.setSecondaryProgress(HealthBar.getProgress());
        ShieldBar.setSecondaryProgress(ShieldBar.getProgress());

        if(ShieldBar.getProgress() > 0)
        {
            if(Amount>0)
            {
                for(int x=0;x<(Amount);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            ShieldBar.incrementProgressBy(1);
                        }
                    }, 4*x);
                }
            }
            else
            {
                for(int x=0;x<(Amount*-1);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            ShieldBar.incrementProgressBy(-1);
                        }
                    }, 5*x);
                }

                for(int x=0;x<(Amount*-1);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            ShieldBar.incrementSecondaryProgressBy(-1);
                        }
                    }, 10*Amount*-1+5*x+100);
                }
            }
        }
        else
        {
            if(Amount>0)
            {
                for(int x=0;x<(Amount);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            HealthBar.incrementProgressBy(1);
                        }
                    }, 4*x);
                }
            }
            else
            {
                for(int x=0;x<(Amount*-1);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            HealthBar.incrementProgressBy(-1);
                        }
                    }, 5*x);
                }

                for(int x=0;x<(Amount*-1);x++) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            HealthBar.incrementSecondaryProgressBy(-1);
                        }
                    }, 10*Amount*-1+5*x+100);
                }


                // Check Enemy Health
                if(true){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after delay
                            gameCheckEnemyHealth(view);
                        }
                    }, 10*Amount*-1+5*Amount+100);
                }

            }
        }


    }


    public void gameHeal(final View view, final int Amount, final int Health, final int Shields)
    {
        //final ProgressBar HealthBar = view.findViewById(R.id.myEnemyHealth);
        //final ProgressBar ShieldBar = view.findViewById(R.id.myEnemyShields);
        final ProgressBar HealthBar = view.findViewById(Health);
        final ProgressBar ShieldBar = view.findViewById(Shields);

        HealthBar.setSecondaryProgress(HealthBar.getProgress());
        ShieldBar.setSecondaryProgress(ShieldBar.getProgress());

        // Shields
        for(int x=0;x<(Amount*2);x++) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    ShieldBar.incrementProgressBy(1);
                }
            }, 3*x);
        }

        // Health
        for(int x=0;x<(Amount);x++) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    HealthBar.incrementProgressBy(1);
                }
            }, 3*x);
        }
    }



}
