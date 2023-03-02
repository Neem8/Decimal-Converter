package com.example.reg;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forget extends AppCompatActivity {
Button forget;
EditText forget_mail;
Integer RandomInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_forget);
        forget_mail = (EditText) findViewById(R.id.forget_mail);
        forget = (Button) findViewById(R.id.forget);

        Random r = new Random();
        RandomInt = r.nextInt(9999-1000);

        }
}