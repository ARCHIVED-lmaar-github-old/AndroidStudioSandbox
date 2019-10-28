package com.example.androidstudiosandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    String msg = "Android : ";
    int SwitchState;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Switch Listener
        Switch myswitch = findViewById(R.id.switch101);
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    SwitchState = 1;

                    // Modify the Text on the TextView
                    final TextView helloTextView = findViewById(R.id.text_view_id_103);
                    helloTextView.setText(R.string.app_desc);

                } else {
                    // The toggle is disabled
                    SwitchState = 0;

                    // Modify the Text on the TextView
                    final TextView helloTextView = findViewById(R.id.text_view_id_103);
                    helloTextView.setText(R.string.app_desc_off);

                    // Toast
                    //Context context = getApplicationContext();
                    //Toast.makeText(context, "OFF", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");

        // Toast.makeText(this, "Application Started", Toast.LENGTH_LONG).show();
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");

        // Modify the Text on the TextView
        final TextView helloTextView = findViewById(R.id.text_view_id_103);
        helloTextView.setText(R.string.app_desc);
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");

        // Modify the Text on the TextView
        final TextView helloTextView = findViewById(R.id.text_view_id_103);
        helloTextView.setText(R.string.onPause);
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }


    /**
     * Menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_new:
                Toast.makeText(this, "Menu: New", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_open:
                Toast.makeText(this, "Menu: Open", Toast.LENGTH_SHORT).show();
                onLaunchTabbedActivity(findViewById(R.id.menu_open));
                return true;
            case R.id.menu_quit:
                Toast.makeText(this, "Menu: Quit", Toast.LENGTH_SHORT).show();
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    // Service - Start
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Service - Stop
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    // onButtonAccept
    public void onButtonAccept(View view) {
        // Toast
        Toast.makeText(this, "Accept Clicked", Toast.LENGTH_LONG).show();

        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                // Call 951-030-0000
                // Uri.parse("tel:9510300000"));

                // Open Browser
                // Uri.parse("https://www.linkedin.com/in/laurencemaar/"));
                Uri.parse("http://example.com"));

        startActivity(i);

    }

    // onSwitch
    public void onSwitch(final View view) {
        // Toast.makeText(this, "Switch Triggered", Toast.LENGTH_SHORT).show();
    }

    // Launch Tabbed Activity
    public void onLaunchTabbedActivity(View view){
        startActivity(new Intent(MainActivity.this,TabbedActivity.class));
    }

}