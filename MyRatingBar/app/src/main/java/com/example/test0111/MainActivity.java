package com.example.test0111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count[]=new int[9]; //누적수
    ImageView iv[]=new ImageView[9];
    int imageID[]={
            R.id.iv2, R.id.iv2,R.id.iv3,
            R.id.iv4, R.id.iv5,R.id.iv6,
            R.id.iv7, R.id.iv8,R.id.iv9
    };

    String imgMsg[]={
            "어벤져스:엔드게임", "걸캅스", "명탐정피카츄",
            "뽀로로극장판보물섬대모험", "몬스터랜드", "교회오빠",
            "로지","물의기억", "배심원들"
    };

    Button btn; //투표결과

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //count배열초기화
        for(int i=0; i<count.length;i++){count[i]=0;}

        for(int i=0; i<imageID.length; i++){
            final int index=i;
            iv[i]=findViewById(imageID[i]);
            iv[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //count[i]++;  for반복문안에 있는 i 쓰면 에러발생
                    count[index]++;
                    Toast tt=Toast.makeText(getApplication(), imgMsg[index]+"  총:"+count[index]+"표" , Toast.LENGTH_SHORT);
                    tt.show();
                }
            });
        }//그림관련 for end

        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(), Two.class);
                it.putExtra("count", count);
                it.putExtra("imgMsg", imgMsg);
                startActivity(it);
            }
        });
    }//onCreate end

}//MainActivity class END
