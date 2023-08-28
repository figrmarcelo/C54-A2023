package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView liste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        liste = findViewById(R.id.liste);
        ArrayAdapter adapter = null;
        try {
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recupererMemos());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        liste.setAdapter(adapter);
    }

    public ArrayList<String> recupererMemos() throws FileNotFoundException {
        ArrayList<String> temp = new ArrayList<String>();
        //3 flux de donnees en lecture
        BufferedReader br;

        try{
            FileInputStream fis = openFileInput("memos.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = br.readLine();

            while (line != null){
               temp.add(line);
               line = br.readLine();
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        return temp;


    }
}