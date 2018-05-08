package com.example.android.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView timerTextView;
    private TextView scoreTextView;
    private TextView sumTextView;
    private TextView resultTextView;

    private Button startButton;
    private Button topLeft;
    private Button topRight;
    private Button bottomLeft;
    private Button bottomRight;
    private Button playAgainButton;

    private int locationOfCorrectAnswer;
    private int score = 0;
    private int numberOfQuestions = 0;

    private boolean playing = false;

    private ConstraintLayout gameLayout;

    private ArrayList<Integer> answers = new ArrayList<>();

    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);

        startButton = findViewById(R.id.startButton);
        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);
        playAgainButton = findViewById(R.id.playAgainButton);

        gameLayout = findViewById(R.id.gameLayout);

        startButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.resultTextView));
    }

    public void chooseAnswer(View view) {
        if (playing) {
            if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
                resultTextView.setText("Correct!");
                score++;
            } else {
                resultTextView.setText("Wrong :(");
            }
            numberOfQuestions++;
            scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            generateQuestion();
        }
    }

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        playing = true;

        generateQuestion();

        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");

        new CountDownTimer(30100, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
                playing = false;
            }
        }.start();
    }

    public void generateQuestion() {
        locationOfCorrectAnswer = rand.nextInt(4);
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        int correctAnswer = a + b;

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(correctAnswer);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == correctAnswer) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
        topLeft.setText(Integer.toString(answers.get(0)));
        topRight.setText(Integer.toString(answers.get(1)));
        bottomLeft.setText(Integer.toString(answers.get(2)));
        bottomRight.setText(Integer.toString(answers.get(3)));
    }
}
