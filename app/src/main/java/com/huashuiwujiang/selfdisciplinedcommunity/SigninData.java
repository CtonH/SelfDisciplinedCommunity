package com.huashuiwujiang.selfdisciplinedcommunity;

import android.media.Image;

import java.util.Date;

public class SigninData {

    private String title;
    private Date date;
    private String place;

    public SigninData(String title, Date date, String place){
        this.title=title;
        this.date=date;
        this.place=place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
