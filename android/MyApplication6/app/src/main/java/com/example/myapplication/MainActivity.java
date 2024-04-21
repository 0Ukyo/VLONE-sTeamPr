package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioButton c1;
RadioButton c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         c1 = findViewById(R.id.chose1);
 c2=findViewById(R.id.chose2);
        EditText e=findViewById(R.id.edit2222);
        if(c1.isChecked()){
            Toast.makeText(this, "ffufuuf", Toast.LENGTH_SHORT).show();
        }
    }
    public void btn1(View v){
       CharSequence str="";
       if(c1.isChecked()){
           str=c1.getText();
           Toast.makeText(this, "hahah", Toast.LENGTH_SHORT).show();
       }
       if(c2.isChecked()){
           str=c2.getText();
           Toast.makeText(this,"wuwuwu",Toast.LENGTH_LONG).show();

       }
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        Log.e("lego",str.toString() );

   }
}