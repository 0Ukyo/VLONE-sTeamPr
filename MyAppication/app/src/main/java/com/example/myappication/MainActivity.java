package com.example.myappication;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private Button regin,login;
    private EditText Count1 ,passW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

 regin=findViewById(R.id.button8);
  login=findViewById(R.id.button9);
  Count1=findViewById(R.id.editTextTextMultiLine2);
 passW=findViewById(R.id.editTextTextPassword4);

    SQLiteOpenHelper helper=DBHelper.getmInstance(this);
    SQLiteDatabase readableDatebase= helper.getReadableDatabase();




        regin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

SQLiteDatabase db=helper.getReadableDatabase();
        String count1=Count1.getText().toString();
        String passworld=passW.getText().toString();


        if(db.isOpen())
        {
            String sql="insert into persons  values(null,?,?)";
            db.execSQL(sql,new String[]{count1,passworld});
            Log.e(TAG,"SUCCESS");
        }


db.close();






    }
});



login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
             SQLiteDatabase db= helper.getReadableDatabase();
        if (db.isOpen()) {
            String count1 = Count1.getText().toString();
            String passworld = passW.getText().toString();
            boolean rightWorld = true;

            Cursor cursor = db.rawQuery("select * from persons", null);
            while (cursor.moveToNext() && rightWorld) {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String passw = cursor.getString((cursor.getColumnIndex("passWorld")));

                if (count1.equals(name) && (passworld.equals(passw))) {
                    rightWorld = false;
                    Log.e(TAG,"登录成功");
                    showSuccessToast("yahu");
                }


            }

            if (rightWorld)
            {

                showErrorToast("妈卖批");

            }
            cursor.close();
            db.close();

        }}
});


    }






    private void showSuccessToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}






