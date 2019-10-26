package com.example.androidstudiosandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String msg = "Android : ";

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");

        // Toast.makeText(this, "Application Started", Toast.LENGTH_LONG).show();
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");

        // Modify the Text on the TextView
        final TextView helloTextView = findViewById(R.id.text_view_id_102);
        helloTextView.setText(R.string.app_desc);
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");

        // Modify the Text on the TextView
        final TextView helloTextView = findViewById(R.id.text_view_id_102);
        helloTextView.setText(R.string.onPause);
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }


    // Service - Start
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Service - Stop
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    // Toast - Accept
    public void toastAccept(View view){
        Toast.makeText(this, "Accept Clicked", Toast.LENGTH_LONG).show();
    }
}
