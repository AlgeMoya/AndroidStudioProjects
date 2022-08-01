package com.example.mythread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    Button btn1, btn2, btn3,  btn4;
    int a=0, b=0, c=0;
    boolean flag = true;

    //while(true){runOnUiThread(Runable인터페이스 매개인자) }
    // Thread 클래스 개체 생성하는 이유가 run() 호출하는 start()는 쓰레드 기술 소속
    Thread my = new Thread() {
        public void run() {
            while (true) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        c++;
                        tv3.setText("c = " + c);
                    }
                });
                try {
                    Thread.sleep(1500);
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            } // while end
        } // run end
    }; // my end

    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                a++;
                tv1.setText("a = " + a);
            } else if (msg.what == 2) {
                b += 10;
                tv2.setText("b = " + b);
            } else if (msg.what == 3) {
                c++;
                tv3.setText("c = " + c);
                // Thread 사용 없이 handler 호출할때 delayMillis를 전달하는 것만으로 구현이 가능
                hand.sendEmptyMessageDelayed(3, 1000); // while 무한루프 기술 X
            } else {

            }
        } // handleMessage end
    }; // hand end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textview1);
        tv2 = findViewById(R.id.textview2);
        tv3 = findViewById(R.id.textview3);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // a++;
                // tv1.setText(" a = " + a);
                hand.sendEmptyMessage(1);
            }
        });//btn1 end

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // b += 10;
                // tv2.setText("b = " + b);
                hand.sendEmptyMessage(2);
            }
        });//btn2 end


        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                my.start(); // start() 함수는 쓰레드 구현 무한처리 run() 함수 호출
                // System.out.println("aaabbbb");
            }
        });//btn3 end

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=false;
                System.out.println("무한루프 정지");
            }
        });
    }// end

}// MainActivity class END