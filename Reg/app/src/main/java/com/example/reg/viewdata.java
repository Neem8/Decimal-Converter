package com.example.reg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<String> user,mail,pass;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
    db = new DatabaseHelper(this);
        user = new ArrayList<>();
        mail = new ArrayList<>();
        pass = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(this,user,mail,pass);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = db.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data Inserted", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                user.add(cursor.getString(0));
                mail.add(cursor.getString(1));
                pass.add(cursor.getString(2));
            }
        }

    }
}