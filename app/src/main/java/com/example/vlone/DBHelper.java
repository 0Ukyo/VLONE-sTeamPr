package com.example.vlone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    // 构造方法
    public DBHelper(Context context) {
        super(context, "myDatabase.db", null, 1);
    }

    // onCreate方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE myTable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)";
        db.execSQL(createTable);
    }

    // onUpgrade方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myTable");
        onCreate(db);
    }
}