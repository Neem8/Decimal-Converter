package com.example.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {

    Button signup;
    EditText user,password,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = (Button) findViewById(R.id.signup);
        user = (EditText) findViewById(R.id.signup_username);
        mail = (EditText) findViewById(R.id.signup_mail);
        password = (EditText) findViewById(R.id.signup_password);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.add(user.getText().toString(),mail.getText().toString(),password.getText().toString());
                Intent i = new Intent(getApplicationContext(),Login.class);
                Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}