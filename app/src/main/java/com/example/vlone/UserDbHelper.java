package com.example.vlone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class UserDbHelper extends SQLiteOpenHelper {

private static SQLiteOpenHelper mInstance;
public static synchronized SQLiteOpenHelper getInstance(Context context)
{
    if(mInstance==null)
    {
        mInstance= new UserDbHelper(context,"derryDB.db",null,1);
    }
    return  mInstance;
}
   private  UserDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
