package com.example.dabaseconnectivity_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqlite extends SQLiteOpenHelper{


    public sqlite(Context context) {
        super(context, "stud_db.db", null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table registeration(user text,mail text,pass text)");
    }


    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists registeration");
    }
}
