package com.example.day0111;

public class Listviewitem {
    // res/drawable // 그림파일은 상수화
    int icon;
    String name;

    public Listviewitem( ){ }

    public Listviewitem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} // class END
