package com.example.triathlonregistrationapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerPerson = 725;
    int numberOfAthletes;
    double totalCost;
    String locationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText number = (EditText)findViewById(R.id.txtAthletes);
        final Spinner location = (Spinner)findViewById(R.id.txtLocation);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View view) {
                numberOfAthletes = Integer.parseInt(number.getText().toString());
                totalCost = costPerPerson * numberOfAthletes;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                locationChoice = location.getSelectedItem().toString();
                result.setText(locationChoice + " race team fee is " + currency.format(totalCost));
            }
        });
    }
}
