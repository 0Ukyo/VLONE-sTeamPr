package com.example.vlone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText A,Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        Button LogIn=findViewById(R.id.ButtonLogIn);


        EditText Code=findViewById(R.id.editTextCODE);


    }

    public void getCount(View view) {
        A=findViewById(R.id.EditTextCOUNT);
      A.getText().toString();
       String Cot=A.getText().toString();
      Log.e("leg","COUNT:"+Cot);

    }
}