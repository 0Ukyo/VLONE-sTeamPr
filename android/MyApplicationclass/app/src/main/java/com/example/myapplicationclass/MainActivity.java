package com.example.myapplicationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
Button jump;
EditText name;
TextView textView;
Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   jump=findViewById(R.id.button1);
   name=findViewById(R.id.edit_one);
   textView=findViewById(R.id.text_1);
  jump.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
          Intent intent= new Intent(MainActivity.this,MainActivity2.class);
          Bundle bundle= new Bundle();
          bundle.putString("info",name.getText().toString());
          bundle.putString("info2","123456789");
          intent.putExtras(bundle);
          startActivityForResult(intent,111);

      }
  });


    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent date) {
        super.onActivityResult(requestCode, resultCode, date);
        if (resultCode == 111 || requestCode == RESULT_OK) {
            Bundle bundle = date.getExtras();
            textView=findViewById(R.id.text_1);
            textView.setText(bundle.getString("return","NBNB"));
        }
        Toast.makeText(this,textView.getText(),Toast.LENGTH_LONG);



    }


    public void check(View view) {


        Toast.makeText(this,textView.getText(),Toast.LENGTH_LONG);

    }
}