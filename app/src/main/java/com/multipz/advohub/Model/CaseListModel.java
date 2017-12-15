package com.multipz.advohub.Model;

/**
 * Created by Admin on 11-12-2017.
 */

public class CaseListModel {

    String img, des, date;

    public CaseListModel(String img, String des, String date) {
        this.img = img;
        this.des = des;
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
