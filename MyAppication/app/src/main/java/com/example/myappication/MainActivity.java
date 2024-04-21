package com.example.myappication;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
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
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    private NotificationManager manager;
    private Notification note,note2;
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

        Toast.makeText(this, "Welcome For Shopping", Toast.LENGTH_SHORT).show();
//manager
        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("1","电商系统",
                    NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
//点击View
       /* Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pending=PendingIntent.getActivity(this,0,intent,0);*/

        note=new NotificationCompat.Builder(this,"1")
                .setContentTitle("电商系统用户注册成功")
                .setContentText("Welcome bro")
                .setSmallIcon(R.drawable.baseline_emoji_flags_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.count))
                .setColor(Color.parseColor("#ff0000"))//设置小图标颜色
                //.setContentIntent(pending)//设置点击动作
                .setAutoCancel(true)
                .build();



        note2 =new NotificationCompat.Builder(this,"1")
                .setContentTitle("电商系统用户登录成功")
                .setContentText("Welcome bro")
                .setSmallIcon(R.drawable.baseline_emoji_flags_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.count))
                .setColor(Color.parseColor("#ff0000"))//设置小图标颜色
                //.setContentIntent(pending)//设置点击动作
                .setAutoCancel(true)
                .build();



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

if (!count1.isEmpty())
{
    if (db.isOpen())
    {

        String sql = "insert into persons  values(null,?,?)";
        db.execSQL(sql, new String[]{count1, passworld});
        Log.e(TAG, "SUCCESS");
        manager.notify(1, note);
    }


    db.close();


}



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

                if (count1.equals(name) && (passworld.equals(passw))&&(!count1.isEmpty())) {
                    rightWorld = false;
                    Log.e(TAG,"登录成功");
                    manager.notify(1,note2);
                    Intent intent=new Intent( );
                    intent.setClass(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                  //  showSuccessToast("yahu");
                }


            }

            if (rightWorld)
            {

                showErrorToast("Goddamn!Do Again");

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






