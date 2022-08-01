package com.example.test0107;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class KakaoAdapter extends BaseAdapter {
    Context ct;
    int layout;
    LayoutInflater inf;
    ArrayList<Fruit> al;

    public KakaoAdapter(Context ct) { // 생성자
        this.ct = ct; // context 대입
    }//end

    public KakaoAdapter(Context ct, int layout,  ArrayList<Fruit> al) { // 생성자
        this.ct = ct; // context 대입
        this.layout = layout; // 레이아웃 대입
        this.inf = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.al = al; // 배열 대입
    }//생성자end

    @Override
    public int getCount() {
        return al.size();
    }//end

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }//end

    @Override
    public long getItemId(int position) {
        return position;
    }//end

    @Override
    public View getView(int position, View cv, ViewGroup parent) {
        if(cv==null) cv=inf.inflate(layout, null); //꼭기술하삼 안그럼 안보임

        ImageView iv=cv.findViewById(R.id.imageView1);
        TextView tName=cv.findViewById(R.id.tvName);
        TextView tTast=cv.findViewById(R.id.tvFrom);
        TextView tDate=cv.findViewById(R.id.tvDate);

        Fruit f = al.get(position);
        iv.setImageResource(f.img);
        tName.setText(f.name);
        tTast.setText(f.taste ? "달콤달콤" : "새콤새콤");
        tDate.setText(f.date);
        return cv;
    }//end
}//KakaoAdpter클래스 end