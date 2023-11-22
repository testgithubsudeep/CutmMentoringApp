package com.example.mentoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelpererp extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "your_database";
    private static final int DATABASE_VERSION = 2;

    public  static final String TABLE_NAME = "student2";
    public static final String COL_ID = "id";
    public static final String COL_SUBJECT = "subject";
    public static final String COL_DESC = "desc";


    public DatabaseHelpererp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SUBJECT + " TEXT, " +
                COL_DESC + "TEXT)";
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
        contentValues.put(COL_SUBJECT, subjects);
        contentValues.put(COL_DESC, descs);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    // Add the following method to your DatabaseHelper class
//    public boolean deleteData(String sname) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, COL_SUBJECT + "=?", new String[]{sname}) > 0;
//    }

}
