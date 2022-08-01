package com.example.test0109;

public class Fruit {
    int img;  //과일그림
    String name; //과일이름
    String from;  //과일원산지
    boolean taste; //과일맛
    String date; //과일입고날짜
    int imgOrigin; // 원산지 국기

    // 숙제 목요일 점심 2시까지 과일나라 리스트 구현해서 제출
    // 원산지 국가국기모양표시 어떻게 할지는 각자 알아서 결정
    // (이름)과일나라listview숙제.zip
    // 항목 하나 더 추가 -> 원산지 국가의 국기 원산지가 페루라면?
    // new Date클래스, Calendar클래스

    public Fruit() {

    }

    // 객체 생성자
    // 과일 이미지, 이름, 맛(boolean), 생산일자, 원산지, 원산지국기
    public Fruit(int img, String name, boolean taste, String date, String from, int imgOrigin) {
        this.img = img;
        this.name = name;
        this.taste = taste;
        this.date = date;
        this.from = from;
        this.imgOrigin = imgOrigin;
    }//end
}//class END