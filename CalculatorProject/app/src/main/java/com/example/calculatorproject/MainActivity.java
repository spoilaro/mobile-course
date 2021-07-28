package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calcButton;
    TextView resultView;
    TextView inputView;
    ImageButton infoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton = findViewById(R.id.calcButton);
        resultView = findViewById(R.id.resultView);
        inputView = findViewById(R.id.inputView);
        infoButton = findViewById(R.id.imageButton2);
    }

    public void updateResult(View view){

        double availableAmount = 650.00;

        String input = inputView.getText().toString();
        double parsedInput = Double.parseDouble(input);

        double res = availableAmount - parsedInput;

        String parsedRes = Double.toString(res);
        parsedRes = parsedRes + "€";

        resultView.setText(parsedRes);
    }
}