package com.example.test0107;

import java.util.Date;

public class Guest {
    String name,title,email ;
    int cnt ;
    java.util.Date wdate;
    boolean gender = false;

    public Guest(){ }

    public Guest(String name, String title, String email, int cnt, Date wdate, boolean gender) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.cnt = cnt;
        this.wdate = wdate;
        this.gender = gender;
    }//end

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}//Guest class END
