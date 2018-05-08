package com.example.android.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void guess(View view) {
        EditText editText = findViewById(R.id.numberGuessed);

        int guessNum = Integer.parseInt(editText.getText().toString());
        String message;

        if (guessNum > randomNumber) {
            message = "Lower";
        } else if (guessNum < randomNumber) {
            message = "Higher";
        } else {
            message = "That is correct, Play Again!";

            generateNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void generateNumber() {
        Random rand = new Random();

        randomNumber = rand.nextInt(50) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }
}
