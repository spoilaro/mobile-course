package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.example.coursework2.work")){
            TextView tv = findViewById(R.id.textView);
            String txt = getIntent().getExtras().getString("com.example.coursework2.work");

            tv.setText(txt);
        }
    }
}