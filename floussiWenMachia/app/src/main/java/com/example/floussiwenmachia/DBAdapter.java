package com.example.floussiwenmachia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBAdapter extends SQLiteOpenHelper {
    public DBAdapter(@Nullable Context context) {
        super(context, "ab", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE flouswenmachia(id integer Primary key ,depense text, valeur float , date text );";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP Table  IF EXISTS flouswenmachia;";
        db.execSQL(deleteTable);
        onCreate(db);
    }

    public void ajoutdepense(NewMasrouf nouveau){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("depense",nouveau.getDepense());
        contentValues.put("valeur",nouveau.getValeur());
        contentValues.put("date",nouveau.getDate());
        db.insert("flouswenmachia",null,contentValues);

    }

    public ArrayList<NewMasrouf> afficher(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM flouswenmachia";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<NewMasrouf> depenses=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                NewMasrouf achat = new NewMasrouf();
                achat.setId(cursor.getInt(0));
                achat.setDepense(cursor.getString(1));
                achat.setValeur(cursor.getFloat(2));
                achat.setDate(cursor.getString(3));
                depenses.add(achat);
            }while(cursor.moveToNext());
        }
        return depenses;}

    public void remove(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("depence","id="+Integer.toString(id),null);}

    }
