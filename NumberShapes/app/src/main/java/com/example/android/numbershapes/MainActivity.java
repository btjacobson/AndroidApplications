package com.example.android.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void testNumber(View view) {
        EditText numberEntered = findViewById(R.id.numberEntered);

        String message;

        if (numberEntered.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {

            NumberShapes myNumber = new NumberShapes();
            myNumber.number = Integer.parseInt(numberEntered.getText().toString());
            message = numberEntered.getText().toString();

            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is square and triangular";
            } else if (myNumber.isSquare()) {
                message += " is square but not triangular";
            } else if (myNumber.isTriangular()) {
                message += " is triangular but not square";
            } else {
                message += " is neither triangular nor square";
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
