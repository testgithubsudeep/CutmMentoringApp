package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityExam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
  Button resultsubmit;
    String[] Semister = {"1st sem", "2nd sem", "3rd sem", "4th sem", "5th sem", "6th sem"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityExam.this, android.R.layout.simple_spinner_item, Semister);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}