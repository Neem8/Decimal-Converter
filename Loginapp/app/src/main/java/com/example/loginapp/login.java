package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
Button login;
EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(user.getText().toString().equals("Ishan") && pass.getText().toString().equals("123")){
                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(login.this, "Error Login", Toast.LENGTH_SHORT).show();
            }
                    }
    });
    }
}