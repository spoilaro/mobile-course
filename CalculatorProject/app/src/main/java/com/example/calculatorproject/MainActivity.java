
package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button calcButton;
    TextView resultView;
    TextView inputView;

    ArrayList<String> suggestion;
    String[] suggestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton = findViewById(R.id.calcButton);
        resultView = findViewById(R.id.resultView);
        inputView = findViewById(R.id.inputView);

        Resources res = getResources();
        suggestion = new ArrayList<String>();

        suggestions = res.getStringArray(R.array.suggestions);
        
    }

    public void updateResult(View view){

        double availableAmount = 650.00;

        String input = inputView.getText().toString();
        double parsedInput = Double.parseDouble(input);

        double res = availableAmount - parsedInput;

        suggestion.add(Double.toString(res));

        String parsedRes = Double.toString(res);
        parsedRes = parsedRes + "€";

        resultView.setText(parsedRes);
    }

    public void goToInfoScreen(View view){
        Intent infoIntent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(infoIntent);
    }

    public void goToHistory(View view){
        Intent historyIntent = new Intent(getApplicationContext(), HistoryActivity.class);

        Bundle args = new Bundle();

        args.putSerializable("ARRAYLIST", (Serializable)suggestion);
        historyIntent.putExtra("SUGGESTION", suggestions);

        startActivity(historyIntent);
    }
}