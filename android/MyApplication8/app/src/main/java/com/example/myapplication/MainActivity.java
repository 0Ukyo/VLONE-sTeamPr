package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private Notification notification;
private NotificationManager manager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel1 =  new NotificationChannel("leo","rs",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel1);
        }


Intent intent= new Intent(MainActivity.this,t.class);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent tt = PendingIntent.getActivity(this,0,intent,0);


        notification=new NotificationCompat.Builder(this,"leo")
                .setContentTitle("体育彩票")
                .setContentText("你中了两亿人民币")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(tt)
                .setAutoCancel(true)
                .build();


    }



    public void set(View view){

manager.notify(1,notification);
    }




    public void cancel(View view) {

    }
}