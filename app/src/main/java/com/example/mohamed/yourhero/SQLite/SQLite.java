package com.example.mohamed.yourhero.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static final String TABLE_QUESTIONS = "table_heroQuestion";
    private static final String COL_ID = "ID";
    private static final String COL_QUESTIONS = "Questions";


    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_QUESTIONS  + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_QUESTIONS + " TEXT NOT NULL);";

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_QUESTIONS + ";");
        onCreate(db);
    }
}
