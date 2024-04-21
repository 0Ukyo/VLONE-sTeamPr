package com.example.myappication;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_LONG;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.database.Cursor;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity2 extends MainActivity implements ImageAdapter.OnItemClickListener   {
    private RecyclerView mRecyclerView;
    private List<Uri> mImageUris;
    private  String namePrice;
    private String   SayIntroduce;
    private static final int REQUEST_CODE = 1; // 你可以根据需要更改这个值
    ArrayList paths = null;
    ArrayList names = null;
    public AlertDialog.Builder builder;
    Uri selectedImageUri;

   private List<Imagea> imageList = new ArrayList<>();
private  Imagea imagea;
private  Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "Welcome For Shopping", Toast.LENGTH_SHORT).show();
        // 获取Resources对象
        Resources res = getResources();
Bitmap bitmap1[]=
        new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.car),
                BitmapFactory.decodeResource(getResources(), R.drawable.weapon),
        BitmapFactory.decodeResource(getResources(), R.drawable.phone),
        BitmapFactory.decodeResource(getResources(), R.drawable.ball),
                BitmapFactory.decodeResource(getResources(), R.drawable.flowe)
        };

// 从资源文件获取Bitmap
        int Va=0;
        for (Bitmap b:bitmap1)
        {

            String name="10"+Integer.toString(Va);
            // 如果需要，可以对Bitmap进行缩放
            int width = 100; // 期望的宽度
            int height = 100; // 期望的高度/
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(b, width, height, false);
            bitmap1[Va]=scaledBitmap;
            ImageView imageView = findViewById(R.id.ImageShop);
            imageView.setImageBitmap(bitmap1[0]);
            Va+=1;

      // imageList.add(new Imagea(scaledBitmap,"",""));
        }

        Imagea imagea1[]=
                {
                        new Imagea(bitmap1[0],"19888800","CAR"),
                        new Imagea(bitmap1[1],"999999999","weapon"),
                        new Imagea(bitmap1[2],"9999","Phone"),
                        new Imagea(bitmap1[3],"298","ball"),
                        new Imagea(bitmap1[4],"19","flower")
                };
       for (Imagea i:imagea1)
        {
            imageList.add(i);

        }
    //////////////////////////////////
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity2.this, 1));// 设置为3列的网格布局
        ImageAdapter adapter = new ImageAdapter(imageList);
        adapter.setOnItemClickListener((ImageAdapter.OnItemClickListener) MainActivity2.this);
        //////////////////////////////////////
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);
        builder.setView(view);
        builder.setTitle("商品信息");
        builder.setMessage("请输入商品信息");
        // 获取EditText控件的引用
     //  final EditText editText = view.findViewById(R.id.editTextNamePrice);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final  EditText editText =view.findViewById(R.id.editTextNamePrice);
                namePrice =editText.getText().toString();
                final EditText editText1 =view.findViewById(R.id.edit_Saying);
                SayIntroduce =editText1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 处理点击取消按钮的事件
                // 从资源文件获取Bitmap
                         dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();

/////////////////////////////////


        Button button=findViewById(R.id.btChose);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      alertDialog.show();

    }
});

////////////////////////////////////////////////////////////////////

Button btnn=findViewById(R.id.Buttonnext);
btnn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



        if(imageList.isEmpty()) {
            String receivedJson = "从客户端接收到的JSON数据";
            gson = new Gson();

            {
                List<Imagea> customClassList = gson.fromJson(receivedJson, new TypeToken<List<Imagea>>() {
                }.getType());
                for (Imagea a : customClassList) {
                    imageList.add(a);
                    Toast.makeText(MainActivity2.this, "读取数据完毕", Toast.LENGTH_SHORT);
                }
            }
        }

        ///////////////////////////////////////////////

        //图片加载
        recyclerView.setAdapter(adapter);
        /////////////////////////////////////////
        Gson gson=new Gson();
        String json = gson.toJson(imageList);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://www.httpbin.org/pos")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // 上传成功
                    Log.e(TAG,"1111111111111111111111SSSSSSSSSSSSSSSSSSSSSSSSSSSSSUUUUUUUUUUUUUUUUUUUUUUUUUCCCCCCCCCCCCCCCCC");
                } else {
                    // 上传失败
                    Log.e(TAG,"22222222222222222222FFFFFFFFFFFFFFFFFFFAAAAAAAAAAAAAAAAAAAAAAAAAAILLLLLLLLLLLLLLLLL");
                }
            }
        });
        //List<String> imageUrls = new ArrayList<>(); // 图片URL列表
      /*  imageUrls.add("https://example.com/image1.jpg");
        imageUrls.add("https://example.com/image2.jpg");
        imageUrls.add("https://example.com/image3.jpg");*/
    }
});

    }





///////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
Bitmap bitmap = null;
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();

            try {
                ContentResolver contentResolver = getContentResolver();
                InputStream inputStream = contentResolver.openInputStream(selectedImageUri);
                 bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                Imagea imagea1 =new Imagea(bitmap,"","");
                imagea1.setName(namePrice);
                imagea1.setLocation(SayIntroduce);
                imageList.add(imagea1);
                TextView textView=findViewById(R.id.textIntroduce);
                textView.setText("商品名："+SayIntroduce);
                //imagea1.setImage(bitmap);
                //imagea1.setLocation("");
               // imagea1.setName("ss");
                // 现在你可以使用bitmap对象进行后续操作，比如显示在ImageView中或保存到文件等
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageView imageView=findViewById(R.id.ImageShop);
            imageView.setImageBitmap(bitmap);
            TextView textView =findViewById(R.id.Textprice);
            textView.setText("售价:"+namePrice+"元");
            Log.d(TAG, "onActivityResult: sssssssssssssssssssssssssssssssssssssssssss");

        }
    }

    @Override
    public void onItemClick(int position, Bitmap bitmap, String price,String name)
    {

        ImageView imageView =findViewById(R.id.ImageShop);
        imageView.setImageBitmap(bitmap);
        TextView textView=findViewById(R.id.Textprice);
        textView.setText("售价"+price+"元");
        TextView textView1=findViewById(R.id.textIntroduce);
        textView1.setText("商品名："+name);
        ///////////////////////////////////


    builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_item, null);
    final  ImageView imageView1=view.findViewById(R.id.dialogImageView);
    imageView1.setImageBitmap(bitmap);
        builder.setView(view);
        builder.setTitle("购买信息");
        builder.setMessage("确定要购买"+name+"吗？");
        // 获取EditText控件的引用
        //  final EditText editText = view.findViewById(R.id.editTextNamePrice);
        builder.setPositiveButton("购买", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity2.this, "请电话联系17306318254", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 处理点击取消按钮的事件
                // 从资源文件获取Bitmap
                dialog.dismiss();
            }
        });
AlertDialog alertDialog=builder.create();
alertDialog.show();







    }


//////////////////////////////////////////////












}
















































