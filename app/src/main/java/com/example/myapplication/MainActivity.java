package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button calc = (Button) findViewById(R.id.button5);
        Button memo = (Button) findViewById(R.id.button4);


        calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                startActivity(intent);
            }

        });
        memo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                startActivity(intent);
            }
        });


    }



}