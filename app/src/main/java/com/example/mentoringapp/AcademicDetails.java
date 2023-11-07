package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AcademicDetails extends AppCompatActivity {
Button academicdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_details);

        academicdetails=findViewById(R.id.academicdetails);

        academicdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AcademicDetails.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AcademicDetails.this,StudentRecord.class);
                startActivity(intent);
            }
        });
        academicdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AcademicDetails.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AcademicDetails.this,StudentRecord.class);
                startActivity(intent);
            }
        });
    }
}