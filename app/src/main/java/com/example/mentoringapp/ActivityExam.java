package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityExam extends AppCompatActivity {
  Button resultsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        resultsubmit=findViewById(R.id.resultsubmit);

        resultsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityExam.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ActivityExam.this,StudentRecord.class);
                startActivity(intent);
            }
        });
    }
}