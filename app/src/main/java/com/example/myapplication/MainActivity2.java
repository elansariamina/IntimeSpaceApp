package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity2 extends AppCompatActivity {

    char currentApplication;
    double value1;
    double value2;
    EditText editText;
    boolean isCalc = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        editText = (EditText) findViewById(R.id.editTextNumber);
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);
        Button b10 = (Button) findViewById(R.id.button10);
        Button b11 = (Button) findViewById(R.id.button11);
        Button b12 = (Button) findViewById(R.id.button12);
        Button b13 = (Button) findViewById(R.id.button13);
        Button b14 = (Button) findViewById(R.id.button14);
        Button b15 = (Button) findViewById(R.id.button15);
        Button b16 = (Button) findViewById(R.id.button16);
        Button retour = (Button) findViewById(R.id.button35);
        Button logout = (Button) findViewById(R.id.button37);

        write(b1);
        write(b2);
        write(b3);
        write(b4);
        write(b5);
        write(b6);
        write(b7);
        write(b8);
        write(b9);
        write(b14);
        write(b15);

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                currentApplication = '*';
                editText.setText("");
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                currentApplication = '+';
                editText.setText("");
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                currentApplication = '-';
                editText.setText("");
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                currentApplication = '/';
                editText.setText("");
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                editText.setText(String.valueOf(value1));
                System.out.println(value1);
                value2 = 0.00;
                value1 = 0.00;
                currentApplication = ' ';
                isCalc = true;
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }
    public void write(Button b){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCalc){
                    String i = (String) b.getText();
                    editText.setText(i);
                    isCalc = false;
                }else {
                    String i = (String) b.getText();
                    editText.setText(editText.getText() + i);
                }
            }
        });
    }
    public void calcul(){
        value2 = Double.parseDouble(editText.getText().toString());
        switch (currentApplication){
            case '+':
                System.out.println("1+:" + value1 + ", " + currentApplication);
                value1 = value1 + value2;
                System.out.println("2+:" + value1 + ", " + currentApplication);
                break;
            case '-':
                System.out.println("1-:" + value1 + ", " + currentApplication);
                value1 = value1 - value2;
                System.out.println("2-:" + value1 + ", " + currentApplication);
                break;
            case '*':
                System.out.println("1*:" + value1 + ", " + currentApplication);
                value1 = value1 * value2;
                System.out.println("2*:" + value1 + ", " + currentApplication);
                break;
            case '/':
                System.out.println("1/:" + value1 + ", " + currentApplication);
                value1 = value1 / value2;
                System.out.println("2/:" + value1 + ", " + currentApplication);
                break;
            default:
                System.out.println("1default:" + value1 + ", " + currentApplication);
                value1 = value2;
                System.out.println("2default:" + value1 + ", " + currentApplication);
        }
    }
}
