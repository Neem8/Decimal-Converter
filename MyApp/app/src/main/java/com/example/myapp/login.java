package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    Button login;
    EditText login_username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        login_username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show();
            }


            public void Show() {
                if (login_username.getText().toString().equals("UTU") && password.getText().toString().equals("123")){
                    Toast.makeText(getApplicationContext(), "Hello " + login_username.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}