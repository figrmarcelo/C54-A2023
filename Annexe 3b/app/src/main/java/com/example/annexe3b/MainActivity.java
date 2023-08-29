package com.example.annexe3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2, seekBar3;
    private int sbValue1, sbValue2, sbValue3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);


        try {
            ObjectInputStream ois = null;
            FileInputStream fis = openFileInput("fichier.ser");
            ois = new ObjectInputStream(fis);

            seekBar1.setProgress((int) ois.readObject());
            seekBar2.setProgress((int) ois.readObject());
            seekBar3.setProgress((int) ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = openFileOutput("fichier.ser", Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);

            sbValue1 = seekBar1.getProgress();
            sbValue2 = seekBar2.getProgress();
            sbValue3 = seekBar3.getProgress();

            oos.writeObject(sbValue1);
            oos.writeObject(sbValue2);
            oos.writeObject(sbValue3);

            //fos.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}