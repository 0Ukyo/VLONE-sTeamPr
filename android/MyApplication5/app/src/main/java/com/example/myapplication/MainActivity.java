package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
private ProgressBar pgb;
private ProgressBar pgb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgb=findViewById(R.id.pgb);
pgb2=findViewById(R.id.pgb2);
    }
    public void  Bsdsss(View view){
if(pgb.getVisibility()==View.GONE){
 pgb.setVisibility(View.VISIBLE);
}else{
    pgb.setVisibility(View.GONE);
}

    }
    public void button2(View view){
        int progress=pgb2.getProgress();
        progress =progress+10;
        pgb2.setProgress(progress);
    }

}