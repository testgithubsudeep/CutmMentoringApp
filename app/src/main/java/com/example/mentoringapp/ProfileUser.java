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

public class ProfileUser extends AppCompatActivity {
    profileHelper myDb;
    EditText regdno, firstname, lastname, age,bloodgroup,birthday,fathername,Foccupation,mothername,Moccupation;
    Button resultsubmit, resultview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        myDb = new profileHelper(this);
        regdno = findViewById(R.id.regdno);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        age = findViewById(R.id.age);
        bloodgroup = findViewById(R.id.bloodgroup);
        birthday = findViewById(R.id.birthday);
        fathername = findViewById(R.id.fathername);
        Foccupation = findViewById(R.id.Foccupation);
        mothername = findViewById(R.id.mothername);
        Moccupation = findViewById(R.id.Moccupation);

        resultsubmit = findViewById(R.id.resultsubmit);
        resultview = findViewById(R.id.resultview);
//        deletecademicdetails= findViewById(R.id.deletecademicdetails);

        resultsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regdnos = regdno.getText().toString();
                String firstnames = firstname.getText().toString();
                String lastnames = lastname.getText().toString();
                String ages = age.getText().toString();
                String bloodgroups = bloodgroup.getText().toString();
                String birthdays = birthday.getText().toString();
                String fathernames = fathername.getText().toString();
                String Foccupations = Foccupation.getText().toString();
                String mothernames = mothername.getText().toString();
                String Moccupations = Moccupation.getText().toString();


                if (regdnos.trim().isEmpty() || firstnames.trim().isEmpty() || lastnames.trim().isEmpty() || ages.trim().isEmpty() ||
                        bloodgroups.trim().isEmpty() || birthdays.trim().isEmpty() || fathernames.trim().isEmpty() || Foccupations.trim().isEmpty() ||mothernames.trim().isEmpty() || Moccupations.trim().isEmpty()) {
                    // Handle empty input fields
                    Toast.makeText(ProfileUser.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDb.insertData(regdnos, firstnames, lastnames, ages,bloodgroups,birthdays,fathernames,Foccupations,mothernames,Moccupations);
                    if (isInserted) {
                        // Data inserted successfully
                        Toast.makeText(ProfileUser.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Failed to insert data
                        Toast.makeText(ProfileUser.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        resultview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    // No data found
                    showMessage("Error", "No data found");
                    return;
                }
//                regdno, firstname, lastname, age,bloodgroup,birthday,fathername,Foccupation,mothername,Moccupation
                StringBuilder buffer = new StringBuilder();
                while (result.moveToNext()) {
                    buffer.append("ID: ").append(result.getString(0)).append("\n");
                    buffer.append(" regdno: ").append(result.getString(1)).append("\n");
                    buffer.append("firstname: ").append(result.getString(2)).append("\n");
                    // Add other fields as needed
                    buffer.append("lastname: ").append(result.getString(3)).append("\n");
                    buffer.append("age: ").append(result.getString(4)).append("\n");
                    buffer.append("bloodgroup: ").append(result.getString(4)).append("\n");
                    buffer.append("birthday: ").append(result.getString(4)).append("\n");
                    buffer.append("fathername: ").append(result.getString(4)).append("\n");
                    buffer.append("Foccupation: ").append(result.getString(4)).append("\n");
                    buffer.append("mothername: ").append(result.getString(4)).append("\n");
                    buffer.append("Moccupation: ").append(result.getString(4)).append("\n");



                }

//                 Show all data
                showMessage("Data", buffer.toString());
            }
        });
//        deletecademicdetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String idToDelete = matric.getText().toString(); // Assuming regd is used as the ID
//                if (!idToDelete.isEmpty()) {
//                    boolean isDeleted = myDb.deleteData(idToDelete);
//                    if (isDeleted) {
//                        // Data deleted successfully
//                        Toast.makeText(Academic_Detailsdb.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
//                        // Optionally, clear the input fields after deletion
//                        clearInputFields();
//                    } else {
//                        // Failed to delete data
//                        Toast.makeText(Academic_Detailsdb.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    // Provide a message to the user to enter the ID for deletion
//                    Toast.makeText(Academic_Detailsdb.this, "Please enter an ID for deletion", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
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