package com.example.myapplication;





import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

private TextView textView;
private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
this.registerForContextMenu(findViewById(R.id.editText));
this.registerForContextMenu(findViewById(R.id.textview));

findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        findViewById(R.id.textview).showContextMenu();

    }

});











    }

       public boolean onCreateOptionsMenu ( Menu menu){
            SubMenu
            subMenu = menu.addSubMenu(0, 0, 0, "send");
            subMenu.add(0, 6, 6, "blue teeth");
            subMenu.add(0, 7, 7, "share friend");
            subMenu.add(0, 8, 8, "share E_mail");
            menu.add(0, 1, 1, "help");
            menu.add(0, 2, 2, "detail");
            menu.add(0, 3, 3, "exit");
            menu.add(0, 4, 4, "add");
            menu.add(0, 5, 5, "remain");
            return true;
        }

public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()) {
                case 0:
                    Toast.makeText(this, "send", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(this, "blue teeth", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(this, "share", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    Toast.makeText(this, "E_mail", Toast.LENGTH_LONG).show();
                    break;
                case 5:
                    Toast.makeText(this, "help", Toast.LENGTH_LONG).show();
                    break;
                case 6:
                    Toast.makeText(this, "detail", Toast.LENGTH_LONG).show();
                    break;
                case 7:
                    Toast.makeText(this, "exit", Toast.LENGTH_LONG).show();
                    break;
                case 8:
                    Toast.makeText(this, "remain", Toast.LENGTH_LONG).show();
                    break;
        default:break;
            }

        return super.onOptionsItemSelected(item);
        }





@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo MenuInfo){
        if(v==findViewById(R.id.textview)){
            menu.add(0,1,0,"cancel");
            menu.add(0,2,0,"past");

        }
        if (v==findViewById(R.id.editText)){
            menu.add(0,3,0,"cupy");
            menu.add(0,4,0,"past");
            menu.add(0,5,0,"delete");

        }
}

@Override

public boolean onContextItemSelected(MenuItem item){

        switch (item.getItemId()){

            case 1:Toast.makeText(this,"cancel",Toast.LENGTH_LONG).show();
            break;
            case 2:Toast.makeText(this,"past",Toast.LENGTH_LONG).show();
            break;
            case 3:
                Toast.makeText(this, "cupy", Toast.LENGTH_LONG).show();
                break;
            case 4:Toast.makeText(this,"past",Toast.LENGTH_LONG).show();
            break;
            case 5:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            default:break;
       }
       return true;
}









}