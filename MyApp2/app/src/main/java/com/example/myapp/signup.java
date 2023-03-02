package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
Button signup;
EditText user,password,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = (Button) findViewById(R.id.signup);
        user = (EditText) findViewById(R.id.username);
        mail = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.add(user.getText().toString(),mail.getText().toString(),password.getText().toString());
                Intent i = new Intent(getApplicationContext(),login.class);
                Toast.makeText(signup.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}