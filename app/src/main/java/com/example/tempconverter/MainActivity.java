package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editText);
        celButton = (Button) findViewById(R.id.celsiusButtonId);
        fButton = (Button) findViewById(R.id.fButtonId);
        showTempTextView = (TextView) findViewById(R.id.showResultTextView);

        // Set up our buttons (event listeners)
        celButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call convertToCelsius()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    // we are good
                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToCelcius(intEditText);

                    String stringResult = String.valueOf(round.format(convertedVal));

                    showTempTextView.setText(stringResult + " C");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call convertToFereinheit()
                String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else {
                    // all is good
                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedFahr = convertToFarenheit(intEditText);

                    String stringResult = String.valueOf(round.format(convertedFahr));

                    showTempTextView.setText(stringResult + " F");
                }
            }
        });

    }

    public double convertToCelcius (double farVal) {
        // [*C] = ([*F] - 32) * 5/9 ==> From Celsus to Fahrenheit
        double resultCel;
        resultCel = (farVal - 32) * 5/9;
        return resultCel;
    }

    public double convertToFarenheit (double celVal) {
        // [*F] = [*C* * 9/5 * 32 ==> From Celsus to Fahrenheit
        double resultFahr;
        resultFahr = (celVal * 9/5) * 32;
        return celVal;
    }
}