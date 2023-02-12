package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    AutoCompleteTextView text;
    EditText titre;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);

        Button save = (Button) findViewById(R.id.button20);
        Button retour = (Button) findViewById(R.id.button17);
        Button logout = (Button) findViewById(R.id.button19);
        layout = (LinearLayout) findViewById(R.id.linearLayout1);
        text = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        titre = (EditText) findViewById(R.id.editTextTextPersonName2);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable editable = text.getText();
                Editable editable1 = titre.getText();
                Chip chip = new Chip(view.getContext());
                chip.setText(editable1);
                chip.setPadding(20, 2, 2, 2);
                chip.setEnabled(true);
                layout.addView(chip);
                text.setText("");
                titre.setText("");

                chip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAlertDialog(editable1.toString(), editable.toString(), chip);
                    }
                });
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

    private void showAlertDialog(String title, String message, Chip chip) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Retour", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text.setText(message);
                titre.setText(title);
                layout.removeView(chip);
            }
        });
        builder.show();
    }


}
