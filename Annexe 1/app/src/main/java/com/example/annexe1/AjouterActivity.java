package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class AjouterActivity extends AppCompatActivity {

    Button buttonAddMemo;
    TextView textAddMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        buttonAddMemo.findViewById(R.id.buttonAddMemo);
        textAddMemo.findViewById(R.id.textAddMemo);

        Ecouteur ec = new Ecouteur();


    }


    private class Ecouteur implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FileOutputStream fos; //flux d'octets
            BufferedWriter bw = null;
            try {
                fos = openFileOutput("memo.txt", Context.MODE_APPEND); // mode append c'est pour ecrire a la fin du fichier. Par defaut ecrit au debut.
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                bw = new BufferedWriter(osw);
                bw.write(textAddMemo.getText().toString());
                bw.newLine();

                //bw.write("\r\n)

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                fermerFlux(bw);
            }

            finish();
        }
    }

    public void fermerFlux (Writer bw){
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}