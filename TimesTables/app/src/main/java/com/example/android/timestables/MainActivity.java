package com.example.android.timestables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;


    public void generateTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar numberSelection = findViewById(R.id.numberSelection);
        timesTableListView = findViewById(R.id.timesTableListView);

        int max = 20;
        int initial = 1;

        numberSelection.setMax(max);
        numberSelection.setProgress(initial);

        generateTable(initial);

        numberSelection.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                generateTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
