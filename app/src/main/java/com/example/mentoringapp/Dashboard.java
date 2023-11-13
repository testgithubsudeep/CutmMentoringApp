package com.example.mentoringapp;
//package com.myfirstapplication.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private Button button_apply;

    String[] Mentor = {"Rakesh sir", "Bubun sir", "Rashmi Sir", "Saroj sir", "Arpita mam", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        spinner=findViewById(R.id.spinner);
<<<<<<< HEAD
        button_apply=findViewById(R.id.facultyerp);
=======
        button_apply=findViewById(R.id.submithostel);
>>>>>>> 91b40ce34edcf0618d97e6c73f023238607a4304
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Dashboard.this, android.R.layout.simple_spinner_item, Mentor);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set up the OnItemSelectedListener
        spinner.setOnItemSelectedListener(this);
        button_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this, StudentRecord.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value = parent.getItemAtPosition(position).toString();
        Toast.makeText(Dashboard.this, value, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle case where nothing is selected (if needed)
    }
}
