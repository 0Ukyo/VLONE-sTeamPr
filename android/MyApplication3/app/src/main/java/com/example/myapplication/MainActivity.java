package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ss= findViewById(R.id.op44444);
        Button bu=findViewById(R.id.button_one);
        Button down=findViewById(R.id.button);
        bu.setOnClickListener(new View.OnClickListener(){
       @Override
       public void onClick(View v){
           ss.setText("sdsdsdkk");

           ss.setTextSize(40);


       }
        });

        down.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ss.setText("sbbbbbbbbbbb");


                return true;
            }
        });

    }
}