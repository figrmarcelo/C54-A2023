package com.example.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListeActivity extends AppCompatActivity {

    ListView ListMemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ListMemo.findViewById(R.id.ListMemo);
    }

    public ArrayList<String> recupererMemos()
    {
        ArrayList<String> temp = new ArrayList<String>();
        FileInputStream fis = openFileInput(fis);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

    }
}