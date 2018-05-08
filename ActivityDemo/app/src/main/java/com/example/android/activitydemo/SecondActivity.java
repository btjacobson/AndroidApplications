package com.example.android.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ageTextView = findViewById(R.id.ageTextView);

        Intent intent = getIntent();
        String friend = intent.getStringExtra("Friend");

        ageTextView.setText(friend);
    }
}
