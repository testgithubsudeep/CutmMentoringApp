package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StudentRecord extends AppCompatActivity {
// Adding student data in record
ImageView persnal,academic,griviance,exam,pdf,about,userprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);
        persnal=findViewById(R.id.persnal);
        academic=findViewById(R.id.academic);
        griviance=findViewById(R.id.griviance);
        exam=findViewById(R.id.exam);
        pdf=findViewById(R.id.pdf);
        about=findViewById(R.id.about);
        userprofile=findViewById(R.id.userprofile);

        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,ProfileUser.class);
                startActivity(intent);
            }
        });

        persnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,Academic_Detailsdb.class);
                startActivity(intent);
            }
        });

        griviance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,ComplainStudent
                        .class);
                startActivity(intent);
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this, ActivityExam.class);
                startActivity(intent);
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,PDFviewer.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentRecord.this,AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}