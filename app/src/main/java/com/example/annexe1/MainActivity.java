package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAjouter, buttonAfficher, buttonQuitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAjouter = findViewById(R.id.buttonAjouter);
        buttonAfficher = findViewById(R.id.buttonAfficher);
        buttonQuitter = findViewById(R.id.buttonQuitter);

        Ecouteur ec = new Ecouteur();

        buttonAjouter.setOnClickListener(ec);
        buttonAfficher.setOnClickListener(ec);
        buttonQuitter.setOnClickListener(ec);







    }

    private class Ecouteur implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if(v==buttonAjouter){
                Intent i = new Intent(MainActivity.this, AjouterActivity.class);
                startActivity(i);
            }
            if(v==buttonAfficher){

            }
            else
                finish();

        }
    }
}