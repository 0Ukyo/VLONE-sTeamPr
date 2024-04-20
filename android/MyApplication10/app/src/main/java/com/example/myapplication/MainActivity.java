package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // groupId--1:分组的id;itemId--100:菜单项的id;order--1:菜单项排序用的;title--"菜单1":菜单名称;
        MenuItem item = menu.add(1, 100, 1, "菜单项");
        item.setTitle("我是一个菜单");
        // 在API>=11时，是不显示图标的

        menu.add(1, 101, 1, "登录");
        menu.add(1, 102, 1, "设置");
        menu.add(1, 103, 1, "退出");

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // 创建菜单项的点击事件
        switch (item.getItemId()) {
            case 101:
                Toast.makeText(this, "你点击了登录", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(this, "你点击了设置", Toast.LENGTH_SHORT).show();
                break;
            case 103:
                Toast.makeText(this, "你点击了退出", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }










}
