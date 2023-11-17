package com.example.mentoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FaclulityReguarding extends AppCompatActivity {
    Button facultyerp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faclulity_reguarding);
        facultyerp=findViewById(R.id.erpregarding);

        facultyerp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FaclulityReguarding.this, " Hostel regarding query Submit Successfully.", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(FaclulityReguarding.this,ComplainStudent.class);
                startActivity(intent);
            }
        });
    }
}