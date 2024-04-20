package com.example.homework;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    Button btnplay, btnnext, btnpre, btnff, btnfr;
    TextView txtNamen, txtsstart, txtsstop;
    SeekBar seekmusic;
    String sname;
    public static final String EXTRA_NAME = "song_name";
    static MediaPlayer mediaPlayer;
    int position;
    ArrayList<File> mySongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
      //  btnff = findViewById(R.id.bntff);
      //  btnfr = findViewById(R.id.bntfr);
        btnnext = findViewById(R.id.btnNext);
        btnpre = findViewById(R.id.bntPre);
        btnplay = findViewById(R.id.playbtn);
        txtNamen = findViewById(R.id.txtsn);
        txtsstart = findViewById(R.id.txtxstart);
        txtsstop = findViewById(R.id.txtxstop);
        seekmusic = findViewById(R.id.seekerbar);


        if (mediaPlayer !=null){

            mediaPlayer.stop();
            mediaPlayer.release();
        }

  Intent i= getIntent();
        Bundle bundle= i.getExtras();

      mySongs=(ArrayList) bundle.getParcelableArrayList("songs");
    String songName= i.getStringExtra("songname");
     position=bundle.getInt("pos",0);
    txtNamen.setSelected(true);
     Uri uri=Uri.parse(mySongs.get(position).toString());
       sname=mySongs.get(position).getName();
       txtNamen.setText(sname);
       btnplay.setBackgroundResource(R.drawable.pause);


       mediaPlayer= MediaPlayer.create(getApplicationContext(),uri);
       mediaPlayer.start();

      btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                   btnplay.setBackgroundResource(R.drawable.play);
                    mediaPlayer.pause();

                }
                else{
                    btnplay.setBackgroundResource(R.drawable.pause);
                    mediaPlayer.start();
                }
            }
        });




      btnnext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mediaPlayer.stop();
              mediaPlayer.release();
              position=((position+1)%mySongs.size());
              Uri u=Uri.parse(mySongs.get(position).toString());
              mediaPlayer=MediaPlayer.create(getApplicationContext(),u);
              sname=mySongs.get(position).getName();
              txtNamen.setText(sname);
              mediaPlayer.start();
              btnplay.setBackgroundResource(R.drawable.pause);
          }
      });



       btnpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                position=((position-1)<0)?(mySongs.size()-1):(position-1);
                Uri u=Uri.parse(mySongs.get(position).toString());
                mediaPlayer=MediaPlayer.create(getApplicationContext(),u);
                sname=mySongs.get(position).getName();
                txtNamen.setText(sname);
                mediaPlayer.start();
                btnplay.setBackgroundResource(R.drawable.pause);
            }
        });




    }




    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0,1,1,"返回");
        menu.add(0,2,2,"退出应用");
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case 1:
                Toast.makeText(this, "欢迎回来", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                AlertDialog.Builder dialog=new AlertDialog.Builder(PlayerActivity.this);
                dialog.setTitle("确认退出应用?");
                dialog.setMessage("你确定退出程序吗？");
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PlayerActivity.this, " 欢迎回来", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create();
                dialog.show();
                break;
            default:break;
        }

        return true;
    }













}