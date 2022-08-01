package com.example.test0107;

public class Fruit {
    int img;  //과일그림
    String name; //과일이름
    String from;  //과일원산지
    boolean taste; //과일맛
    String date; //과일입고날짜
    String originflag;
    // 숙제 목요일 점심 2시까지 과일나라 리스트 구현해서 제출
    // 원산지 국가국기모양표시 어떻게 할지는 각자 알아서 결정
    // (이름)과일나라listview숙제.zip
    // 항목 하나 더 추가 -> 원산지 국가의 국기 원산지가 페루라면?
    // new Date클래스, Calendar클래스

    public Fruit() {

    }

    public Fruit(int img, String name, boolean taste, String date) {
        this.img = img;
        this.name = name;
        this.taste = taste;
        this.date = date;
    }//end
}//class END