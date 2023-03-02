package com.example.dabaseconnectivity_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
EditText user,pass;
Button add,remove,update,view;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);
        update = findViewById(R.id.update);
        view = findViewById(R.id.view);
        db = new DatabaseHelper(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = user.getText().toString();//abc
                String pass1 = pass.getText().toString();//123

                boolean verify = db.add(user1, pass1);//true,false
                if (verify == true) {
                    Toast.makeText(MainActivity.this, "Record inserted successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Record not inserted successfully", Toast.LENGTH_LONG).show();
                }
            }


        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = user.getText().toString();
                String pass1 = pass.getText().toString();

                boolean verify = db.update(user1, pass1);//t f
                if (verify == true) {
                    Toast.makeText(MainActivity.this, "Record update successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Record update successfully", Toast.LENGTH_LONG).show();
                }
            }


        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = user.getText().toString();
                //String pass1 = pass.getText().toString();
                boolean verify = db.remove(user1);
                if (verify == true) {
                    Toast.makeText(MainActivity.this, "Record deleted successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Record deleted successfully", Toast.LENGTH_LONG).show();
                }
            }


        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=db.fetch();
                if(c.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "Record not found", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (c.moveToNext())
                {
                    stringBuffer.append("user"+c.getString(0)+"\n");
                    stringBuffer.append("pass"+c.getString(1)+"\n\n\n");
                }
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setCancelable(true);
                alertDialog.setTitle("Student Data");
                alertDialog.setMessage(stringBuffer.toString());
                alertDialog.show();
            }
        });
    }
}