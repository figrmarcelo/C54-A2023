// Classe: SingletonMemo

package com.example.annexe1;


import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SingletonMemos {

    private static SingletonMemos instance;
    private Context context;
    private ArrayList<String> listMemos;

    public static SingletonMemos getInstance(Context context){
        if (instance == null)
            instance = new SingletonMemos(context);
        return instance;
    }

    private SingletonMemos(Context context){

        this.context = context;
        listMemos = new ArrayList<String>();
    }

    public void ajouterMemo(String memo){
        listMemos.add(memo);
    }

    public ArrayList<String> getListMemos() {
        return listMemos;
    }
    // Serialisation: conserver l'etat d'un objet en donnees binaire que peuvent etre recuperees par la suite
    // Pour nos propre classes : class Maison implements Serialisable (s'assurer que tous les variables de la class le soie aussi)

    public void serialiserListe() throws Exception{
        ObjectOutputStream oss = null;
        try{
            FileOutputStream fos = context.openFileOutput("fichier.ser", Context.MODE_PRIVATE);
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listMemos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            oss.close();

        }
    }



    public ArrayList<String> recupererListe() throws Exception {
        ObjectInputStream ois = null;
        ArrayList<String> temp = null;
        try {
            FileInputStream fis = context.openFileInput("fichier.ser");
            ois = new ObjectInputStream(fis);
            temp = (ArrayList<String>) ois.readObject();


        }
        finally {
            ois.close();
        }

        return temp;
    }

}