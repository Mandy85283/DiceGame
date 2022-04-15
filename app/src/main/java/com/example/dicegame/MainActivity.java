package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
 Spinner spinner;
 String data[] = {"4","6","8","10","12","20"};
 ArrayList list= new ArrayList(Arrays.asList(data));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        TextView result = findViewById(R.id.Result);
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        Button Dice = findViewById(R.id.rollonce);
        Dice.setOnClickListener(view -> {
            String dice = spinner.getSelectedItem().toString();
            int n =  Integer.parseInt(dice);
            Random rand = new Random();
            int number = rand.nextInt((n+1) - 1)+ 1;
            result.setText(String.valueOf(number));
        });
        Button Dice1 = findViewById(R.id.rolltwice);
        Dice1.setOnClickListener(view -> {
            String dice = spinner.getSelectedItem().toString();
            int n =  Integer.parseInt(dice);
            Random rand = new Random();
            int number = rand.nextInt((n+1) - 1)+ 1;
            int number1 = rand.nextInt((n+1) - 1)+ 1;
            result.setText(String.valueOf(number+","+ number1));

        });
        Button add = findViewById(R.id.add);
        add.setOnClickListener(view -> {

            EditText a =(EditText)findViewById(R.id.newdice);
            String newdice = a.getText().toString();
            if (newdice.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_LONG).show();
            }
            else {
                if (Arrays.asList(data).contains(newdice)){
                    Toast.makeText(getApplicationContext(),"Dice already Available",Toast.LENGTH_LONG).show();

                }else {
                    list.add(newdice);
                    adapter.notifyDataSetChanged();
                    spinner.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "New Dice is Added to Spinner", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}