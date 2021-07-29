package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView historyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();

        String[] suggestions = intent.getStringArrayExtra("SUGGESTION");

        historyList = findViewById(R.id.historyList);
        ArrayAdapter<Double> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, suggestions);
        historyList.setAdapter(adapter);
    }

    public void goBack(View v){
        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);
    }
}