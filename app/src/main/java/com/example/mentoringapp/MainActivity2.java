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

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText sname, sregd, sdob, sbranch,semail,sblood,sphone,sadress;
    Button sadd, sview,sdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new DatabaseHelper(this);
        sname = findViewById(R.id.sname);
        sregd = findViewById(R.id.sregd);
        sdob = findViewById(R.id.sdob);
        sbranch = findViewById(R.id.sbranch);
        semail = findViewById(R.id.semail);
        sblood = findViewById(R.id.sblood);
        sphone = findViewById(R.id.sphone);
        sadress = findViewById(R.id.sadress);
        sadd = findViewById(R.id.sadd);
        sview = findViewById(R.id.sview);
        sdelete= findViewById(R.id.sdelete);

        sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sname.getText().toString();
                String regd = sregd.getText().toString();
                String dob = sdob.getText().toString();
                String branch = sbranch.getText().toString();
                String email = semail.getText().toString();
                String blood = sblood.getText().toString();
                String phone = sphone.getText().toString();
                String address = sadress.getText().toString();

                if (name.trim().isEmpty() || regd.trim().isEmpty() || dob.trim().isEmpty() || branch.trim().isEmpty() ||
                        email.trim().isEmpty() || blood.trim().isEmpty() || phone.trim().isEmpty() || address.trim().isEmpty()) {
                    // Handle empty input fields
                    Toast.makeText(MainActivity2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(name, regd, dob, branch, email, blood, phone, address);
                    if (isInserted) {
                        // Data inserted successfully
                        Toast.makeText(MainActivity2.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Failed to insert data
                        Toast.makeText(MainActivity2.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sview.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("Name: ").append(result.getString(1)).append("\n");
                    buffer.append("Regd: ").append(result.getString(2)).append("\n");
                    // Add other fields as needed
                    buffer.append("DOB: ").append(result.getString(3)).append("\n");
                    buffer.append("Branch: ").append(result.getString(4)).append("\n");
                    buffer.append("Email: ").append(result.getString(5)).append("\n");
                    buffer.append("Blood: ").append(result.getString(6)).append("\n");
                    buffer.append("Phone: ").append(result.getString(7)).append("\n");
                    buffer.append("Address: ").append(result.getString(8)).append("\n\n");
                }

                // Show all data
                showMessage("Data", buffer.toString());
            }
        });
        sdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idToDelete = sname.getText().toString(); // Assuming regd is used as the ID
                if (!idToDelete.isEmpty()) {
                    boolean isDeleted = myDb.deleteData(idToDelete);
                    if (isDeleted) {
                        // Data deleted successfully
                        Toast.makeText(MainActivity2.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                        // Optionally, clear the input fields after deletion
                        clearInputFields();
                    } else {
                        // Failed to delete data
                        Toast.makeText(MainActivity2.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Provide a message to the user to enter the ID for deletion
                    Toast.makeText(MainActivity2.this, "Please enter an ID for deletion", Toast.LENGTH_SHORT).show();
                }
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
