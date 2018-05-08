package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow, 1 - Red, 2 - Empty
    int activePlayer = 0;
    boolean gameActive = true;

    int[] gameState = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    int[][] winningPositions = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // Horizontal
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // Vertical
            { 0, 4, 8 }, { 2, 4, 6 }               // Diagonal
    };

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else if (activePlayer == 1) {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    // Someone has won!
                    gameActive = false;
                    String winner = "";

                    if (activePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }

                    Button playAgain = findViewById(R.id.playAgainButton);
                    TextView winnerText = findViewById(R.id.winnerTextView);

                    winnerText.setText(winner + " has won!");

                    playAgain.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {
        Button playAgain = findViewById(R.id.playAgainButton);
        TextView winnerText = findViewById(R.id.winnerTextView);

        playAgain.setVisibility(View.INVISIBLE);
        winnerText.setVisibility(View.INVISIBLE);

        android.support.v7.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);
        }

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        activePlayer = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
