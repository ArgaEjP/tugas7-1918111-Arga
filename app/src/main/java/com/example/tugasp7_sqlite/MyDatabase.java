package com.example.tugasp7_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_museum";
    private static final String tb_museum = "tb_museum";
    private static final String tb_museum_id = "id";
    private static final String tb_museum_nama = "nama";
    private static final String tb_museum_alamat = "alamat";
    private static final String tb_museum_email = "email";
    private static final String CREATE_TABLE_MUSEUM = "CREATE TABLE " + tb_museum + "(" + tb_museum_id + " INTEGER PRIMARY KEY ," + tb_museum_nama + " TEXT," + tb_museum_alamat + " TEXT," + tb_museum_email + " TEXT " + ")";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MUSEUM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }

    public void CreateMuseum(Museum mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_museum_id, mdNotif.get_id());
        values.put(tb_museum_nama, mdNotif.get_namamuseum());
        values.put(tb_museum_alamat, mdNotif.get_alamat());
        values.put(tb_museum_email, mdNotif.get_email());
        db.insert(tb_museum, null, values);
        db.close();
    }

    public List<Museum> ReadMuseum() {
        List<Museum> judulModelList = new ArrayList<Museum>();
        String selectQuery = "SELECT * FROM " + tb_museum;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Museum mdKontak = new Museum();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_namamuseum(cursor.getString(1));
                mdKontak.set_alamat(cursor.getString(2));
                mdKontak.set_email(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateMuseum(Museum mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_museum_nama, mdNotif.get_namamuseum());
        values.put(tb_museum_alamat, mdNotif.get_alamat());
        values.put(tb_museum_email, mdNotif.get_email());
        return db.update(tb_museum, values, tb_museum_id + " = ?",
                new String[]{
                        String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMuseum(Museum mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_museum, tb_museum_id + " = ?", new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

