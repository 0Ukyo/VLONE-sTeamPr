package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;












}

public class MainActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu(0, 0, 0, "send").setIcon(R.drawable.add);
        subMenu.add(0, 6, 6, "blue teeth");
        subMenu.add(0, 7, 7, "share friend");
        subMenu.add(0, 8, 8, "share E_mail");
        menu.add(0, 1, 1, "help").setIcon(R.drawable.help);
        menu.add(0, 2, 2, "detail").setIcon(R.drawable.detail);
        menu.add(0, 3, 3, "exit").setIcon(R.drawable.exit);
        menu.add(0, 4, 4, "add").setIcon(R.drawable.add);
        menu.add(0, 5, 5, "remain").setIcon(R.drawable.remain);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onMenuSelected(int featureId, MenuItem item) {


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
        }

        return super.onMenuItemSelected(featureId, item);
    }
}