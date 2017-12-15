package com.multipz.advohub.Model;

/**
 * Created by Admin on 11-12-2017.
 */

public class PostCaseModel {
    String img, name;

    public PostCaseModel(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
