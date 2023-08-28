package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Ecouteur ec;
    Button ajouter, afficher, quitter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajouter = findViewById(R.id.ajouter);
        afficher = findViewById(R.id.afficher);
        quitter = findViewById(R.id.quitter);

        Ecouteur ec = new Ecouteur ();
        ajouter.setOnClickListener(ec);
        afficher.setOnClickListener(ec);
        quitter.setOnClickListener(ec);
    }

    public class Ecouteur implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent i;
            if(v == ajouter)
            {
                i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }

            else if (v == afficher)
            {
                i = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(i);
            }

            else //bouton terminer
            {
                finish();
            }


        }
    }


}