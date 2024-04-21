package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
private RadioButton ch1,ch2,ch3;
private TextView textView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton ch1 = findViewById(R.id.radioButton2), ch2 = findViewById(R.id.radioButton3), ch3 = findViewById(R.id.radioButton4);
        TextView textView = findViewById(R.id.text6);
    }

    public void onClick(View v){



          mediaPlayer=new MediaPlayer();
            mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.messsd);
            mediaPlayer.start();


        }
    }













