package com.example.my30_recylerview2;

public class PersonDTO {
    String name;
    String phoneNum;
    int resId;

    public PersonDTO() {
    }

    public PersonDTO(String name, String phoneNum, int resId) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
