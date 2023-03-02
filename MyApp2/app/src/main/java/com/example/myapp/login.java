package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class login extends AppCompatActivity {
    Button login;
    EditText login_username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        login = (Button) findViewById(R.id.login);
        login_username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show();
            }


            public void Show() {
                if (login_username.getText().toString().equals("Neem") && password.getText().toString().equals("123")){
                    Toast.makeText(getApplicationContext(), "Hello " + login_username.getText(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}