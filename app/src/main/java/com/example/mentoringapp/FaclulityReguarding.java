package com.example.mentoringapp;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FaclulityReguarding extends AppCompatActivity {
    DatabaseHelpererp myDb;
    EditText subject, desc;
    Button view1,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faclulity_reguarding);

        myDb = new DatabaseHelpererp(this);
        subject = findViewById(R.id.subject);
        desc = findViewById(R.id.desc);


        view1 = findViewById(R.id.view1);
        submit = findViewById(R.id.submit1);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjects = subject.getText().toString();
                String descs = desc.getText().toString();


                if (subjects.trim().isEmpty() || descs.trim().isEmpty() ) {
                    // Handle empty input fields
                    Toast.makeText(FaclulityReguarding.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(subjects, descs);
                    if (isInserted) {
                        // Data inserted successfully
                        Toast.makeText(FaclulityReguarding.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Failed to insert data
                        Toast.makeText(FaclulityReguarding.this, "Failed to insert data "+isInserted, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        view1
                .setOnClickListener(new View.OnClickListener() {
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
                            buffer.append("matrics: ").append(result.getString(1)).append("\n");
                            buffer.append("plus2s: ").append(result.getString(2)).append("\n");
                            // Add other fields as needed
//                            buffer.append("coursenames: ").append(result.getString(3)).append("\n");
//                            buffer.append("graduations: ").append(result.getString(4)).append("\n");

                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }

                    private void showMessage(String error, String no_data_found) {
                    }
                });
    }
    private void clearInputFields() {
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