package com.example.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class home extends AppCompatActivity {
Button Update,Remove,View;
EditText user,mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        user = (EditText) findViewById(R.id.update_username);
        mail = (EditText) findViewById(R.id.update_mail);
        pass = (EditText) findViewById(R.id.update_password);
        Update = (Button) findViewById(R.id.Update);
        Remove = (Button) findViewById(R.id.Remove);
        View = (Button) findViewById(R.id.View);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                db.update(user.getText().toString(),mail.getText().toString(),pass.getText().toString());
            }
        });
        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                db.remove(user.getText().toString(),mail.getText().toString(),pass.getText().toString());
            }
        });
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(getApplicationContext(),viewdata.class);
                startActivity(i);
            }
        });
    }
}