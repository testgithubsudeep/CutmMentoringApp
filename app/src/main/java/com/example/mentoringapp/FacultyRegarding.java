package com.example.mentoringapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FacultyRegarding extends AppCompatActivity {
    DatabaseHelperfaculty myDb;
    EditText subject, desc;
    Button submit,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_reguarding);

        myDb = new DatabaseHelperfaculty(this);
        subject = findViewById(R.id.subject);
        desc = findViewById(R.id.desc);
        submit = findViewById(R.id.submit);
        view = findViewById(R.id.view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjects = subject.getText().toString();
                String descs = desc.getText().toString();

                if (subjects.trim().isEmpty() || descs.trim().isEmpty()) {
                    // Handle empty input fields
                    Toast.makeText(FacultyRegarding.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(subjects, descs);
                    if (isInserted) {
                        Toast.makeText(FacultyRegarding.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearInputFields(); // Clear input fields after successful insertion
                    } else {
                        Toast.makeText(FacultyRegarding.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    // No data found
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (result.moveToNext()) {
                    buffer.append("ID: ").append(result.getString(0)).append("\n");
                    buffer.append("Subject: ").append(result.getString(1)).append("\n");
                    buffer.append("Description: ").append(result.getString(2)).append("\n");

                }

                // Show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

    private void clearInputFields() {
        // Clear input fields
        subject.getText().clear();
        desc.getText().clear();
    }
    private void showMessage(String title, String message) {
        // Display alert dialog with the specified title and message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
