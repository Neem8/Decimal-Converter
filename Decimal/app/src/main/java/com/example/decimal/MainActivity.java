package com.example.decimal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText input;
TextView output;
Button binary,octal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText) findViewById(R.id.input);
        output=(TextView) findViewById(R.id.output);
        binary = (Button) findViewById(R.id.binary);
        octal = (Button) findViewById(R.id.octal);
        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String op = input.getText().toString();
            Integer decimal = Integer.parseInt(op);
                if (decimal == 0) {
                    output.setText("0");
                }
                String binary = "";
                while (decimal > 0) {
                    int rem = decimal % 2;
                    binary = rem + binary;
                    decimal = decimal / 2;
                }
                output.setText(binary.toString());
            }
        });

        octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op = input.getText().toString();
                Integer decimal = Integer.parseInt(op);
                StringBuilder octalNumber = new StringBuilder();
                int quotient = decimal;

                while (quotient > 0) {
                    int remainder = quotient % 8;
                    octalNumber.append(remainder);
                    quotient = quotient / 8;
                }

                output.setText(octalNumber.reverse().toString());
            }
        });
    }
}