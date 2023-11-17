package com.example.mentoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class profileHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "academic_student";
    private static final int DATABASE_VERSION = 2;
//    firstname, lastname, age,bloodgroup,birthday,fathername,Foccupation,mothername,Moccupation
    public  static final String TABLE_NAME = "Profile_user";
    public static final String COL_ID = "id";
    public static final String COL_REGDNO = "regdno";
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_LASTNAME = "lastname";
    public static final String COL_AGE= "age";
    public static final String COL_BOOLDGROUP= "bloodgroup";
    public static final String COL_BIRTHDAY= "birthday";
    public static final String COL_FATHERSNAME= "fathername";
    public static final String COL_FOCCUPATION= "Foccupation";
    public static final String COL_MOTHERNAME= "mothername";
    public static final String COL_MOCCUPATION= "Moccupation";

    public profileHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_REGDNO + " TEXT, " +
                COL_FIRSTNAME + " TEXT, " +
                COL_LASTNAME + " TEXT, " +
                COL_AGE+ " TEXT ,"+
               COL_BOOLDGROUP+ " TEXT ,"+
                 COL_BIRTHDAY + " TEXT ,"+
                COL_FATHERSNAME + " TEXT ,"+
                COL_FOCCUPATION + " TEXT ,"+
                COL_MOTHERNAME + " TEXT ,"+
                COL_MOCCUPATION + " TEXT )";


        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades, if needed
        // For simplicity, you can drop the table and recreate it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String regdnos, String firstnames, String lastnames, String ages, String bloodgroups, String birthdays, String fathernames, String foccupations, String mothernames, String moccupations) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_REGDNO,regdnos );
        contentValues.put(COL_FIRSTNAME, firstnames);
        contentValues.put( COL_LASTNAME, lastnames);
        contentValues.put(COL_AGE, ages);
        contentValues.put(COL_BOOLDGROUP, bloodgroups);
        contentValues.put( COL_BIRTHDAY, birthdays);
        contentValues.put(COL_FATHERSNAME, fathernames);
        contentValues.put(COL_FOCCUPATION, foccupations);
        contentValues.put( COL_MOTHERNAME , mothernames);
        contentValues.put(COL_MOCCUPATION, moccupations);


        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    // Add the following method to your DatabaseHelper class
    public boolean deleteData(String matrics) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_FIRSTNAME + "=?", new String[]{matrics}) > 0;
    }


}