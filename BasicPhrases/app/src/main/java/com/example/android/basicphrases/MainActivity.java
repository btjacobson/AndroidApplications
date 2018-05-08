package com.example.android.basicphrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean isPlaying = false;
    MediaPlayer mediaPlayer;

    public void playPhrase(View view) {
        Button buttonPress = (Button) view;

        mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(
                buttonPress.getTag().toString(), "raw", getPackageName()));

        if (!isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
        }
        isPlaying = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
