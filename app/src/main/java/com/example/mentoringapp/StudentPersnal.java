package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentPersnal extends AppCompatActivity {
 Button studentdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_persnal);

        studentdetails=findViewById(R.id.studentdetails);

        studentdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentPersnal.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(StudentPersnal.this,StudentRecord.class);
                startActivity(intent);
            }
        });
    }
}