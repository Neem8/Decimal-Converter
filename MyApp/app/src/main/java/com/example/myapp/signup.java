package com.example.myapp;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signup extends AppCompatActivity {
    Button signup;
    EditText user,mail,pass;
    com.example.myapp.DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        DatabaseHelper db =new DatabaseHelper(getApplicationContext());
        user= (EditText) findViewById(R.id.user) ;
        mail= (EditText) findViewById(R.id.mail) ;
        pass= (EditText) findViewById(R.id.pass) ;
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = user.getText().toString();//abc
                String pass1 = pass.getText().toString();//123
                String mail1 = mail.getText().toString();
                boolean verify = db.add(user1,mail1,pass1);//true,false
                if (verify == true) {
                    Toast.makeText(getApplicationContext(), "Record inserted successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),login.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Record not inserted successfully", Toast.LENGTH_LONG).show();
                }

            }
        });
    }



}