package com.example.homework;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button changePicture,openMusic;
    private int[] imgs={

R.drawable.backgroun3,
R.drawable.background,
            R.drawable.back3,
            R.drawable.back6,
            R.drawable.back7,
            R.drawable.back8,
    };
   ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
imageView=findViewById(R.id.imageView);
    changePicture=findViewById(R.id.button2);


       changePicture.setOnClickListener(new View.OnClickListener(){
           int index=0;
           @Override

          public void onClick(View v){


if (index <5) {
    imageView.setImageResource(imgs[index]);
    index++;
}
else{imageView.setImageResource(imgs[index]);
    index=0;
}

           }

       });

       //更换头像
        EditText name=findViewById(R.id.editTextTextPersonName);
        openMusic=findViewById(R.id.button);
        openMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Music.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",name.getText().toString());
                intent.putExtras(bundle);
               startActivity(intent);
            }
        });



//跳转






















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
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
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
                       Toast.makeText(MainActivity.this, " 欢迎回来", Toast.LENGTH_SHORT).show();
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















