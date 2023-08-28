package com.example.annexe1;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SingletonMemo {
    private static SingletonMemo instance;
    private Context contexte;

    private ArrayList<String> listeMemos;

    public static SingletonMemo getInstance;


    public static SingletonMemo getInstance(Context contexte) {
        if (instance == null)
            instance = new SingletonMemo(contexte);
        return instance;


    }

    private SingletonMemo(Context contexte) {
        this.contexte = contexte;
        listeMemos = new ArrayList<String>();
    }

    public ArrayList<String> getListeMemos() {
        return listeMemos;
    }

    public void setListeMemos(ArrayList<String> listeMemos) {this.listeMemos= listeMemos;}

    public void serialiserListeMemos(){
        ObjectOutputStream oos = null;

        try{
            FileOutputStream fos = contexte.openFileOutput("ficher.ser", Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listeMemos);
        } catch ()
    }

}
