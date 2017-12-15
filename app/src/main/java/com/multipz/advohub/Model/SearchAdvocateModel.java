package com.multipz.advohub.Model;

/**
 * Created by Admin on 08-12-2017.
 */

public class SearchAdvocateModel {

    String lawyer_name, lawyer_type, img;

    public SearchAdvocateModel(String lawyer_name, String lawyer_type, String img, boolean ischeck) {
        this.lawyer_name = lawyer_name;
        this.lawyer_type = lawyer_type;
        this.img = img;
        this.ischeck = ischeck;
    }

    boolean ischeck;

    public String getLawyer_name() {
        return lawyer_name;
    }

    public void setLawyer_name(String lawyer_name) {
        this.lawyer_name = lawyer_name;
    }

    public String getLawyer_type() {
        return lawyer_type;
    }

    public void setLawyer_type(String lawyer_type) {
        this.lawyer_type = lawyer_type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
