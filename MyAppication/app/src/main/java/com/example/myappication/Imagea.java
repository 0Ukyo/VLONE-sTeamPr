package com.example.myappication;

import android.graphics.Bitmap;

/** 图像信息类 */
public class Imagea {

    private Bitmap image;
    private String name;
    private String describe;

    public Imagea(Bitmap image, String name, String describe) {
        this.image = image;
        this.name = name;
        this.describe = describe;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setLocation(String location) {
        this.describe = location;
    }
}