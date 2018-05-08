package com.example.android.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this, "Seconds left: " +
                        String.valueOf(millisUntilFinished / 1000), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}
