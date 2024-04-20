package com.example.myapplicationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
private TextView tt;
private  Button returnBack;
private Intent intent;
private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        returnBack=findViewById(R.id.return_one);
       intent =this.getIntent();
        bundle=intent.getExtras();
       String getinfo= bundle.getString("info")+"\n" + bundle.getString("info2");
       tt=findViewById(R.id.text_one);
       tt.setText(getinfo);
        Toast.makeText(this,tt.getText(),Toast.LENGTH_LONG).show();

        returnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("return","来至第二个activity");
                intent.putExtras(bundle);
                MainActivity2.this.setResult(RESULT_OK, intent);
                MainActivity2.this.finish();

            }
        });


    }


    @Override
    public void onBackPressed(){
        bundle.putSerializable("return","come from b");
        MainActivity2.this.setResult(RESULT_OK,intent);
        MainActivity2.this.finish();
    }

}