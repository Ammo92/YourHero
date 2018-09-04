package com.example.mohamed.yourhero.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Requete {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "infos.db";

    private static final String TABLE_QUESTIONS = "table_heroQuestion";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_QUESTIONS = "Questions";
    private static final int NUM_COL_QUESTION = 0;

    private SQLiteDatabase bdd ;
    private SQLite maBaseSQLite;

    public Requete(Context context){
        maBaseSQLite = new SQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertInfo(Questions questions){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_QUESTIONS, questions.getQuestions());
        return  bdd.insert(TABLE_QUESTIONS, null, values);
    }

    public Questions getInfoWithId(int id){
        open();
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_QUESTIONS, new String[] {COL_ID, COL_QUESTIONS}, COL_ID + " LIKE  " + id , null, null, null, null);
        Log.e("Requete : ",String.valueOf(c));
        return cursorToLivre(c);
    }

    private Questions cursorToLivre(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0){
            return null;
        }
        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Questions questions = new Questions();
        questions.setQuestions(c.getString(NUM_COL_QUESTION));

        //On ferme le cursor
        c.close();

        //On retourne le livre
        return questions;
    }

}
