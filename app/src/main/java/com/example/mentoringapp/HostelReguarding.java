package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HostelReguarding extends AppCompatActivity {
    Button submithostel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_reguarding);
        submithostel=findViewById(R.id.submit1);
        submithostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HostelReguarding.this, " Hostel regarding query Submit Successfully.", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(HostelReguarding.this,ComplainStudent.class);
                startActivity(intent);
            }
        });

    }
}