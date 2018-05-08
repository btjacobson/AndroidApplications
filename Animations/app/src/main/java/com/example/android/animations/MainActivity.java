package com.example.android.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean starOff = true;

    public void fade(View view) {
        ImageView starView = findViewById(R.id.starView);
        ImageView starViewOn = findViewById(R.id.starViewOn);

        if (starOff) {
            starView.animate().alpha(0).setDuration(2000);
            starViewOn.animate().alpha(1).setDuration(2000);
            starOff = false;

        } else {
            starViewOn.animate().alpha(0).setDuration(2000);
            starView.animate().alpha(1).setDuration(2000);

            starOff = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
