package com.example.mentoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseERP extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mentoring_database";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "student4";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "subjects";
    public static final String COL_REGD = "descs";

    public DatabaseERP(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_REGD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades, if needed
        // For simplicity, you can drop the table and recreate it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String subjects, String descs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, subjects);
        contentValues.put(COL_REGD, descs);

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

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public boolean deleteData(String sname) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_NAME + "=?", new String[]{sname}) > 0;
    }
}
