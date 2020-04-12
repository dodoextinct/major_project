package com.example.aqindicator;

import android.media.Image;
import android.widget.ImageView;

public class User {
    public String name;
    public String aqi;
    public int img;
    public String desc;
    public String time;
    public String back;


    public User(String name, String aqi, int img, String desc, String time, String back) {

        this.name = name;
        this.aqi = aqi;
        this.img = img;
        this.desc = desc;
        this.time = time;
        this.back = back;
    }

    public int getImageId() {
        return img;
    }

    public void setImageId(int imageId) {
        this.img = imageId;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getName() {
        return name;
    }

    public void setName(String desc) {
        this.name = desc;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String title) {
        this.aqi = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


