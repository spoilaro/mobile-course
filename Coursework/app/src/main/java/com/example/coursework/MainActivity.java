package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t1 = findViewById(R.id.editTextNumber);
                EditText t2 = findViewById(R.id.editTextNumber2);
                TextView res = findViewById(R.id.textView);

                int num1 = Integer.parseInt(t1.getText().toString());
                int num2 = Integer.parseInt(t2.getText().toString());

                int result = num1 + num2;

                res.setText(result + "");
            }
        });

    }
}