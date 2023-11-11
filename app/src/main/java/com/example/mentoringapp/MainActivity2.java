package com.example.mentoringapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText nameEditText, surnameEditText, markEditText, idEditText;
    Button addButton, displayButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new DatabaseHelper(this);
        nameEditText = findViewById(R.id.name);
        surnameEditText = findViewById(R.id.surname);
        markEditText = findViewById(R.id.mark);
        idEditText = findViewById(R.id.id);
        addButton = findViewById(R.id.button);
        displayButton = findViewById(R.id.add);
        updateButton = findViewById(R.id.update);
        deleteButton = findViewById(R.id.delete);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String surname = surnameEditText.getText().toString();
                String mark = markEditText.getText().toString();

                if (name.trim().isEmpty() || surname.trim().isEmpty() || mark.trim().isEmpty()) {
                    // Handle empty input fields
                    Toast.makeText(MainActivity2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(name, surname, mark);
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

        displayButton.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("Surname: ").append(result.getString(2)).append("\n");
                    buffer.append("Mark: ").append(result.getString(3)).append("\n\n");
                }

                // Show all data
                showMessage("Data", buffer.toString());
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String surname = surnameEditText.getText().toString();
                String mark = markEditText.getText().toString();
                boolean isUpdated = myDb.updateData(id, name, surname, mark);
                if (isUpdated) {
                    // Data updated successfully
                    Toast.makeText(MainActivity2.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Failed to update data
                    Toast.makeText(MainActivity2.this, "Failed to update data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                boolean isDeleted = myDb.deleteData(id);
                if (isDeleted) {
                    // Data deleted successfully
                    Toast.makeText(MainActivity2.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Failed to delete data
                    Toast.makeText(MainActivity2.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
