package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
     /*  AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
       dialog.setTitle("OUt ?");
       dialog.setMessage("and you want to leave");
       dialog.setIcon(R.drawable.ic_launcher_foreground);

       dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
       dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });








       dialog.create();
               dialog.show();



*/    /* EditText editText= new EditText(MainActivity.this);
       EditText editText1=new EditText(MainActivity.this);
       AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("check in");
       dialog.setView(editText);


        dialog.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        dialog.setNegativeButton("cancel",null);
        dialog.create();
        dialog.show();

*/

      String[] arrayHobby={"basketball","baseball","soccerBall","badminton"};
        AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Favourate");

                dialog.setSingleChoiceItems(arrayHobby, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
Toast.makeText(MainActivity.this,arrayHobby[i],Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("cancel",null);
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"yahu",Toast.LENGTH_LONG).show();
                    }
               });
                dialog.create()
                        .show();






    }


    }
