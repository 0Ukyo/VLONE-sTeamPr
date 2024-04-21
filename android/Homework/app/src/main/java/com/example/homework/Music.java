package com.example.homework;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class Music extends AppCompatActivity {
ListView listView;
String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        String name = bundle.getString("name");

        Toast toast = Toast.makeText(this, "欢迎回来" + name, Toast.LENGTH_SHORT);
        toast.show();


        // Toast

        listView = findViewById(R.id.ListViewSong);
        runtimePermission();

//
    // listView.setOnItemClickListener(new mItemClick());

    }

  /* class mItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?>arg0,View arg1,int arg2,long arg3){
            Toast.makeText(Music.this, "yahed", Toast.LENGTH_SHORT).show();
         long songName = listView.getItemIdAtPosition(arg2);



        }
    }

*/


   public void runtimePermission()
    {
        Dexter.withContext(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                     displaySong();
                    }



                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                         permissionToken.continuePermissionRequest();

                    }
                }).check();


    }






















    public ArrayList<File> findSong(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null){
            for (File singlefile : files) {
                if (singlefile.isDirectory() && !singlefile.isHidden()) {
                    arrayList.addAll(findSong(singlefile));
                } else {
                    if (singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".wav")) {
                        arrayList.add(singlefile);
                    }

                }
            }
    }
            return arrayList;
        }


















void  displaySong()
{
    final ArrayList<File>mySongs=findSong(Environment.getExternalStorageDirectory());
    items=new String[mySongs.size()];
    for (int i=0; i<mySongs.size(); i++) {
        items[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");


    //    listView.setOnItemClickListener(new mItemClick());

    }
    ArrayAdapter<String>myAdapter= new ArrayAdapter<>(this, com.karumi.dexter.R.layout.support_simple_spinner_dropdown_item,items);
    listView.setAdapter(myAdapter);



listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     //   Toast.makeText(Music.this, "dddddddd", Toast.LENGTH_SHORT).show();
        String songName= (String) listView.getItemAtPosition(position);
     startActivity(new Intent(getApplicationContext(),PlayerActivity.class)
             .putExtra("songs",mySongs)
             .putExtra("songname",songName)
             .putExtra("pos",position));
    }
});





        }












    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0,1,1,"返回");
        menu.add(0,2,2,"退出应用");
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case 1:
                Toast.makeText(this, "欢迎回来", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                AlertDialog.Builder dialog=new AlertDialog.Builder(Music.this);
                dialog.setTitle("确认退出应用?");
                dialog.setMessage("你确定退出程序吗？");
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Music.this, " 欢迎回来", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create();
                dialog.show();
                break;
            default:break;
        }

        return true;
    }










    }
































