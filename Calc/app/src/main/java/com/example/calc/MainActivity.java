package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText num1,num2;
TextView result;
Button add,sub,div,mul;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        result= (TextView) findViewById(R.id.result);
        add=(Button) findViewById(R.id.add);
        sub=(Button) findViewById(R.id.sub);
        mul=(Button) findViewById(R.id.mul);
        div=(Button) findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op1=num1.getText().toString();
                String op2=num2.getText().toString();
                Integer value = (Integer.parseInt(op1)+Integer.parseInt(op2));
                result.setText(value.toString());
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op1=num1.getText().toString();
                String op2=num2.getText().toString();
                Integer value = Integer.parseInt(op1)-Integer.parseInt(op2);
                result.setText(value.toString());
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op1=num1.getText().toString();
                String op2=num2.getText().toString();
                Integer value = Integer.parseInt(op1)*Integer.parseInt(op2);
                result.setText(value.toString());
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op1=num1.getText().toString();
                String op2=num2.getText().toString();
                Integer value = Integer.parseInt(op1)/Integer.parseInt(op2);
                result.setText(value.toString());
            }
        });
    }
}