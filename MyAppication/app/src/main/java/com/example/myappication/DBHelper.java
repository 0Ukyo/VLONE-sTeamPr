package com.example.myappication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private  static SQLiteOpenHelper mInstance;
    public  static synchronized SQLiteOpenHelper getmInstance(Context context)
    {
        if (mInstance==null)
        {
            mInstance=new DBHelper(context,"derryDB.db",null,1);

        }
        return mInstance;

    }
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql="create table persons(_id integer primary key autoincrement,name text,passWorld text)";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // 构造方法

}
