package com.multipz.advohub.Model;

/**
 * Created by Admin on 01-12-2017.
 */

public class FeedBackModel {

    String clientname, work;

    public FeedBackModel(String clientname, String work) {
        this.clientname = clientname;
        this.work = work;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
