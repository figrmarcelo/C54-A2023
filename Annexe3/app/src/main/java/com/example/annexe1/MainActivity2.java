package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainActivity2 extends AppCompatActivity {
    Button boutonAjouter;
    EditText champ;
    Ecouteur ec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boutonAjouter = findViewById(R.id.Bajouter);
        champ = findViewById(R.id.texteEntre);

        ec = new Ecouteur();
        boutonAjouter.setOnClickListener(ec);
    }


    public class Ecouteur implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            //L'ajouter localemnent

        }

        public void fermerFlux(Writer bw){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}