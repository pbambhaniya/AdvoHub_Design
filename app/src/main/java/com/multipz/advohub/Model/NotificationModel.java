package com.multipz.advohub.Model;

/**
 * Created by Admin on 04-12-2017.
 */

public class NotificationModel {


    String name,time,img;

    public NotificationModel(String name, String time, String img) {
        this.name = name;
        this.time = time;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
