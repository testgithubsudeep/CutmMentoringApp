package com.example.mentoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "your_database_name";
    private static final int DATABASE_VERSION = 2;

    public  static final String TABLE_NAME = "student2";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_REGD = "regd";
    public static final String COL_DOB = "dob";
    public static final String COL_BRANCH = "branch";
    public static final String COL_EMAIL = "email";
    public static final String COL_BLOOD = "blood";
    public static final String COL_PHONE = "phone";
    public static final String COL_ADDRESS = "address";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_REGD + " TEXT, " +
                COL_DOB + " TEXT, " +
                COL_BRANCH + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_BLOOD + " TEXT, " +
                COL_PHONE + " TEXT, " +
                COL_ADDRESS + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades, if needed
        // For simplicity, you can drop the table and recreate it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String regd, String dob, String branch, String email, String blood, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_REGD, regd);
        contentValues.put(COL_DOB, dob);
        contentValues.put(COL_BRANCH, branch);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_BLOOD, blood);
        contentValues.put(COL_PHONE, phone);
        contentValues.put(COL_ADDRESS , address);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    // Add the following method to your DatabaseHelper class
    public boolean deleteData(String sname) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_NAME + "=?", new String[]{sname}) > 0;
    }

}
