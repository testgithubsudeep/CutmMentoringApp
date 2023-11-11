package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubjectReguarding extends AppCompatActivity {
    Button submiterp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_reguarding);
        submiterp=findViewById(R.id.facultyerp);
        submiterp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReguarding.this, "Subject Submit Successfully", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SubjectReguarding.this,ComplainStudent.class);
                startActivity(intent);
            }
        });

    }
}