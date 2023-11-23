package com.example.mentoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class academicHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "academic_student";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_NAME = "academic_details";
    public static final String COL_ID = "id";
    public static final String COL_MATRICS = "matrics";
    public static final String COL_PLUS2 = "plus2s";
    public static final String COL_COURSENAME = "coursenames";
    public static final String COL_RESULT= "graduations";

    public academicHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_MATRICS + " TEXT, " +
                COL_PLUS2 + " TEXT, " +
                COL_COURSENAME + " TEXT, " +
                COL_RESULT + " TEXT )";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades, if needed
        // For simplicity, you can drop the table and recreate it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String matrics, String plus2s, String coursenames, String graduations) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_MATRICS, matrics);
        contentValues.put(COL_PLUS2, plus2s);
        contentValues.put(COL_COURSENAME, coursenames);
        contentValues.put(COL_RESULT, graduations);

        try {
            long result = db.insert(TABLE_NAME, null, contentValues);
            return result != -1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close(); // Close the database connection
        }
    }


//    traversing and processing the results of a database query.
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // Add the following method to your DatabaseHelper class
    public boolean deleteData(String matrics) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_MATRICS + "=?", new String[]{matrics}) > 0;
    }
}
