package com.example.android.eggtimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar timerSeekBar;
    private TextView timerTextView;
    private Button startButton;

    CountDownTimer countDownTimer;
    private boolean counterIsActive = false;

    private int maxTime = 600;
    private int defaultTime = 30;

    public void resetTimer() {
        timerTextView.setText("00:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startButton.setText("START");
        counterIsActive = false;
    }

    public void startTimer(View view) {
        if (counterIsActive) {
            resetTimer();
        } else {

            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            startButton.setText("STOP");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.foghorn);
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }
    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - (minutes * 60);

        String minuteString = Integer.toString(minutes);
        String secondString = Integer.toString(seconds);

        if (minutes <= 9) {
            minuteString = "0" + minuteString;
        }
        if (seconds <= 9) {
            secondString = "0" + secondString;
        }

        timerTextView.setText(minuteString + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.countdownTextView);
        startButton = findViewById(R.id.startButton);

        timerSeekBar.setMax(maxTime);
        timerSeekBar.setProgress(defaultTime);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("Seekbar Value", seekBar.toString());

            }
        });

    }
}
