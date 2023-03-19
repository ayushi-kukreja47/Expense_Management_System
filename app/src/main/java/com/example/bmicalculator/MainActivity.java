package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWt;
        EditText edtHft;
        EditText edtHin;
        Button btn;
        TextView txt;
        LinearLayout llMain;

        edtWt=findViewById(R.id.edtWt);
        edtHft=findViewById(R.id.edtHft);
        edtHin=findViewById(R.id.edtHin);
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.txt);
        llMain=findViewById(R.id.llMain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWt.getText().toString());
                int ft = Integer.parseInt(edtHft.getText().toString());
                int in = Integer.parseInt(edtHin.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalH = totalCm / 100;
                double bmi = wt / (totalH * totalH);

                if (bmi > 25) {
                    txt.setText("You are overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                } else if (bmi<18) {
                    txt.setText("You are underweight");
                    llMain.setBackgroundColor((getResources().getColor(R.color.colorUW)));
                }
                else{
                    txt.setText("You are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });


    }
}