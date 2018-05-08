package com.example.android.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        TextView currency = findViewById(R.id.amountEditText);

        float currencyAfter = Float.valueOf(currency.getText().toString());
        float convertedCurrency = currencyAfter * .81f;
        
        String finalCurrency = Float.toString(convertedCurrency);

        Toast.makeText(this, "$" + currency.getText().toString() +
                " is £" + finalCurrency, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
