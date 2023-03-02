package com.example.dabaseconnectivity_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {

        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase d) {
        d.execSQL("create table stud_tbl(user text,pass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase d, int i, int i1) {
        d.execSQL("drop table if exists stud_tbl");
    }

    public Boolean add(String user, String pass) {
//get writable database and pass it to db
        SQLiteDatabase db = this.getWritableDatabase();//insert,update,delete
        //to put the values inside table
        ContentValues c = new ContentValues();
        c.put("user", user);
        c.put("pass", pass);
        long result = db.insert("stud_tbl", null, c);
        if (result == -1)
            return false;
        else

            return true;
    }


    public Boolean update(String user, String pass) {
//get writable database and pass it to db
        SQLiteDatabase db = this.getWritableDatabase();
        //to put the values inside table
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("pass", pass);
        //cursor is used to select a rows one by one
        Cursor cursor = db.rawQuery("select * from stud_tbl where user=?", new String[]{user});
        if (cursor.getCount() > 0) {
            long result = db.update("stud_tbl", contentValues, "user=?", new String[]{user});
            if (result == -1)
                return false;
            else

                return true;
        } else {
            return false;
        }
    }

    public Boolean remove(String user) {
//get writable database and pass it to db
        SQLiteDatabase db = this.getWritableDatabase();
        //to put the values inside table
        //cursor is used to select a rows one by one
        Cursor cursor = db.rawQuery("select * from stud_tbl where user=?", new String[]{user});
        if (cursor.getCount() > 0) {
            long result = db.delete("stud_tbl", "user=?", new String[]{user});
            if (result == -1)
                return false;
            else

                return true;
        } else {
            return false;
        }
    }


    public Cursor fetch() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from stud_tbl", null);
        return cursor;
    }
}
