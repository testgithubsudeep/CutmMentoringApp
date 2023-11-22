package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ComplainStudent extends AppCompatActivity {
    TextView faculity,hostel,subject,erp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_student);

        faculity=findViewById(R.id.faculity);
        hostel=findViewById(R.id.hostel);
        subject=findViewById(R.id.subject);
        erp=findViewById(R.id.erp);


        faculity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ComplainStudent.this, FacultyRegarding.class);
                startActivity(intent);
            }
        });

        hostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ComplainStudent.this,HostelReguarding.class);
                startActivity(intent);
            }
        });

        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ComplainStudent.this,SubjectReguarding.class);
                startActivity(intent);
            }
        });

        erp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ComplainStudent.this,ERPReguarding.class);
                startActivity(intent);
            }
        });

    }
}