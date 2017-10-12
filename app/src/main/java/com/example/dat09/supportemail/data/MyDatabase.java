package com.example.dat09.supportemail.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Dat09 on 9/28/2017.
 */

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final String emailTemplate = "emailtemplate";
    private static final int DATABASE_VERSION = 2;


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getTemplateEmal() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("select * from " + emailTemplate, null);
    }


    public long themDL(String title, String supject, String content, String type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title );
        contentValues.put("subject",supject );
        contentValues.put("content", content);
        contentValues.put("type",type);
        return database.insert(emailTemplate, null, contentValues);
    }
}