package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ERPReguarding extends AppCompatActivity {
    Button submiterp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erpreguarding);
        submiterp=findViewById(R.id.submiterp);
        submiterp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ERPReguarding.this, " ERP Submit Successfully", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ERPReguarding.this,ComplainStudent.class);
                startActivity(intent);
            }
        });


    }
}