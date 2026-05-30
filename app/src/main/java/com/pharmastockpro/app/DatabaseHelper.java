package com.pharmastockpro.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    
    private static final String DB_NAME = "PharmaStock.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_PRODUITS = "produits";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUITS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nom TEXT, " +
                "prix REAL, " +
                "quantite INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUITS);
        onCreate(db);
    }

    public boolean ajouterProduit(String nom, double prix, int qte) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom", nom);
        cv.put("prix", prix);
        cv.put("quantite", qte);
        long result = db.insert(TABLE_PRODUITS, null, cv);
        return result != -1;
    }

    public Cursor getAllProduits() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_PRODUITS, null);
    }
          }
