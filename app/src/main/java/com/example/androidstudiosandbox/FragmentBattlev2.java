package com.example.androidstudiosandbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

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

    int EnemyNumber = 1;
    String[] EnemyName = {"Cheese", "Bob", "Jennifer", "Ray", "Charles", "Lolo", "Mike", "Papa", "Mama", "Jessica", "Parker"};

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
                gameReset( view, 1 );
            }
        });

        // Initial Game Reset
        gameReset( view );

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



    public void gameReset(View view)
    {
        gameReset(view, 0);
    }


    public void gameReset(View view, final int showSnackbar)
    {
        // Health
        final ProgressBar pHealthBar = view.findViewById(R.id.myPlayerHealth);
        pHealthBar.setProgress(pHealthBar.getMax());
        pHealthBar.setSecondaryProgress(pHealthBar.getMax());

        // Shields
        final ProgressBar pShieldBar = view.findViewById(R.id.myPlayerShields);
        pShieldBar.setProgress(pShieldBar.getMax());
        pShieldBar.setSecondaryProgress(pShieldBar.getMax());

        // Health
        final ProgressBar eHealthBar = view.findViewById(R.id.myEnemyHealth);
        eHealthBar.setProgress(eHealthBar.getMax());
        eHealthBar.setSecondaryProgress(eHealthBar.getMax());

        // Shields
        final ProgressBar eShieldBar = view.findViewById(R.id.myEnemyShields);
        eShieldBar.setProgress(eShieldBar.getMax());
        eShieldBar.setSecondaryProgress(eShieldBar.getMax());

        // XP
        final TextView helloTextView = view.findViewById(R.id.textPlayerXP);
        final ProgressBar PlayerXP = view.findViewById(R.id.myPlayerXP);
        PlayerXP.setProgress(0);
        helloTextView.setText(String.format("XP: %d / %d", 0, PlayerXP.getMax()));

        // Set Enemy Name
        EnemyNumber=1;
        setEnemyName(view);

        // Toast
        //Toast.makeText(getActivity(), "Reset", Toast.LENGTH_LONG).show();

        // Snackbar
        if(showSnackbar > 0) {
            Snackbar.make(getActivity().findViewById(android.R.id.content), "Game Reset", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }


    public void gameCheckEnemyHealth(View view) {
        final ProgressBar HealthBar = view.findViewById(R.id.myEnemyHealth);
        final ProgressBar ShieldBar = view.findViewById(R.id.myEnemyShields);

        if(HealthBar.getProgress() < 5)
        {
            // Give XP
            final ProgressBar PlayerXP = view.findViewById(R.id.myPlayerXP);
            int XP_Earned = generateRandom(25,10);
            PlayerXP.incrementProgressBy(XP_Earned);

            // Update XP
            final TextView helloTextView = view.findViewById(R.id.textPlayerXP);
            helloTextView.setText(String.format("XP: %d / %d", PlayerXP.getProgress(), PlayerXP.getMax()));

            // Pop-up
            if(PlayerXP.getProgress() >= PlayerXP.getMax())
            {
                popup_win();
            }
            else
            {
                popup_xp(String.format("Enemy Defeated!\nXP Earned: %d", XP_Earned));
            }

            // Reset Enemy
            HealthBar.setProgress(HealthBar.getMax());
            HealthBar.setSecondaryProgress(HealthBar.getMax());
            ShieldBar.setProgress(ShieldBar.getMax());
            ShieldBar.setSecondaryProgress(ShieldBar.getMax());

            // Increment Enemy
            EnemyNumber++;

            // Set Enemy Name
            setEnemyName(view);
        }

    }

    public void setEnemyName(View view)
    {
        // Set Enemy Name
        final TextView tvEnemyName = view.findViewById(R.id.textEnemy);
        tvEnemyName.setText(Html.fromHtml(String.format("ENEMY <font color='#ff0000'>%d</font>: <font color='#3333ff'>%s</font>", EnemyNumber, EnemyName[EnemyNumber%11])));
    }


    public void popup_xp(String displaythis)
    {
        // inflate the layout of the popup_xp window
        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //View popupView = inflater.inflate(R.layout.popup_window_grey, null);

        final View popupView = getLayoutInflater().inflate(R.layout.popup_window_grey, null);

        // create the popup_xp window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup_xp also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup_xp window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

        // Update Pop-Up Text
        final TextView tv = popupView.findViewById(R.id.textPopUp);
        tv.setText(displaythis);

        // dismiss the popup_xp window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void popup_win()
    {
        // inflate the layout of the popup_xp window
        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //View popupView = inflater.inflate(R.layout.popup_window_grey, null);

        final View popupView = getLayoutInflater().inflate(R.layout.popup_window_green, null);

        // create the popup_xp window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup_xp also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup_xp window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

        // Update Pop-Up Text
        //final TextView tv = popupView.findViewById(R.id.textPopUp);
        //tv.setText(displaythis);

        // dismiss the popup_xp window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
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
            // Shield Attack 1
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

            // Shield Attack 2
            for(int x=0;x<(Amount*-1);x++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        ShieldBar.incrementSecondaryProgressBy(-1);
                    }
                }, 10*Amount*-1+5*x+50);
            }
        }
        else
        {
            // Health Attack 1
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

            // Health Attack 2
            for(int x=0;x<(Amount*-1);x++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        HealthBar.incrementSecondaryProgressBy(-1);
                    }
                }, 10*Amount*-1+5*x+50);
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
                }, 10*Amount*-1+5*Amount*-1+150);
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
