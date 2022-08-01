package com.example.test0109;

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

        ImageView iv1 = cv.findViewById(R.id.imageView1); // 사진
        TextView tName = cv.findViewById(R.id.tvName); // 이름
        TextView tTaste = cv.findViewById(R.id.tvTaste); // 맛
        TextView tDate = cv.findViewById(R.id.tvDate); // 일자
        ImageView iv2 = cv.findViewById(R.id.imageView2); // 원산지 국기
        TextView tOrigin = cv.findViewById(R.id.tvOrigin); // 원산지 국가

        Fruit f = al.get(position); // 생성 시 입력받은 배열을 불러온다.
        iv1.setImageResource(f.img); // ImageView iv1에 과일 사진 대입
        tName.setText(f.name); // TextView tName에 이름 대입
        tTaste.setText(f.taste ? "달콤달콤" : "새콤새콤"); // boolean으로 구분해서 TextView tTaste에 맛 대입
        tDate.setText(f.date); // TextView tDate에 생산일자 대입
        tOrigin.setText("원산지 : " + f.from); // TextView tOrigin에 원산지 대입
        iv2.setImageResource(f.imgOrigin); // Imageview iv2에 원산지 국기 대입
        return cv;
    }//end
}//KakaoAdpter클래스 end