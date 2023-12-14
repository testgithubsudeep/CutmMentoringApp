package com.example.mentoringapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Academic_Detailsdb extends AppCompatActivity {
    academicHelper myDb;
    EditText matric, plus2, coursename, result;
    Button submit, view, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_detailsdb);

        myDb = new academicHelper(this);
        matric = findViewById(R.id.matric);
        plus2 = findViewById(R.id.plus2);
        coursename = findViewById(R.id.coursename);
        result = findViewById(R.id.result);

        submit = findViewById(R.id.submit);
        view = findViewById(R.id.view);
        delete = findViewById(R.id.delete);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matrics = matric.getText().toString();
                String plus2s = plus2.getText().toString();
                String coursenames = coursename.getText().toString();
                String results = result.getText().toString();
//                removing white spac char
                if (matrics.trim().isEmpty() || plus2s.trim().isEmpty() || coursenames.trim().isEmpty() || results.trim().isEmpty()) {
                    // Handle empty input fields
                    Toast.makeText(Academic_Detailsdb.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(matrics, plus2s, coursenames, results);
                    if (isInserted) {
                        // Data inserted successfully
                        Toast.makeText(Academic_Detailsdb.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearInputFields(); // Clear input fields after successful insertion

                    } else {
                        // Failed to insert data
                        Toast.makeText(Academic_Detailsdb.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                to fetch a single row
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    // No data found
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (result.moveToNext()) {
                    buffer.append("ID: ").append(result.getString(0)).append("\n");
                    buffer.append("matrics: ").append(result.getString(1)).append("\n");
                    buffer.append("plus2s: ").append(result.getString(2)).append("\n");
                    // Add other fields as needed
                    buffer.append("coursenames: ").append(result.getString(3)).append("\n");
                    buffer.append("results: ").append(result.getString(4)).append("\n");
//                     add the specified string
                }

                // Show all data
                showMessage("Data", buffer.toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idToDelete = matric.getText().toString(); // Assuming matric is used as the ID
                if (!idToDelete.isEmpty()) {
                    boolean isDeleted = myDb.deleteData(idToDelete);
                    if (isDeleted) {
                        // Data deleted successfully
                        Toast.makeText(Academic_Detailsdb.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                        // Optionally, clear the input fields after deletion
                        clearInputFields();
                    } else {
                        // Failed to delete data
                        Toast.makeText(Academic_Detailsdb.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Provide a message to the user to enter the ID for deletion
                    Toast.makeText(Academic_Detailsdb.this, "Please enter an ID for deletion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void clearInputFields() {
        // Clear input fields
        matric.getText().clear();
        plus2.getText().clear();
        coursename.getText().clear();
        result.getText().clear();
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
