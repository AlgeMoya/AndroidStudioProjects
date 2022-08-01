package com.example.test0109;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListTwo extends AppCompatActivity {
    ArrayList<Fruit> al = new ArrayList<Fruit>();
    Fruit m1;
    KakaoAdapter dap;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_two);

        lv=findViewById(R.id.listView1);

        // 과일 이미지, 이름, 맛(boolean), 생산일자, 원산지, 원산지국기
        // 맛은 단건 달다고, 신건 시다고 말해야
        // al = new ArrayList<Fruit>(); // 위에서 이미 초기화했음
        al.add(new Fruit(R.drawable.melon,"메론",true, "2021.09.02", "대한민국", R.drawable.korea)); // 대한민국
        al.add(new Fruit(R.drawable.lemon,"레몬",false, "2021.12.21", "미국", R.drawable.usa)); // 미국
        al.add(new Fruit(R.drawable.plum,"자두",false, "2022.01.03", "대한민국", R.drawable.korea)); // 대한민국
        al.add(new Fruit(R.drawable.cherry,"체리",true, "2022.01.12", "칠레", R.drawable.chile)); // 칠레
        al.add(new Fruit(R.drawable.banana,"바나나",true, "2021.12.08", "필리핀", R.drawable.philippines)); // 필리핀
        al.add(new Fruit(R.drawable.avocado,"아보카도",true, "2021.11.08", "페루", R.drawable.peru)); // 페루
        // al.add(new Fruit(R.drawable.singer4,"소냐",false, "2021.10.08")); // 과일 아니라 추가 애매함

        //ArrayAdapter dap = new ArrayAdapter(ListTwo.this, android.R.layout.simple_spinner_dropdown_item, al);
        dap = new KakaoAdapter(this, R.layout.kakao, al ); // KakaoAdapter에 kakao 레이아웃 파일과 과일 배열을 전송한다.
        lv.setAdapter(dap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Fruit ff = (Fruit)dap.getItem(pos);
                String msg = ff.name + "과일선택하셨군요";
                int imgNum = ff.img;

                View dlg = View.inflate(ListTwo.this, R.layout.display, null);
                ImageView poster = dlg.findViewById(R.id.ivPoster);
                poster.setImageResource(imgNum);

                AlertDialog.Builder ab = new AlertDialog.Builder(adapterView.getContext());
                ab.setTitle("상세정보");
                ab.setIcon(R.drawable.kg1);
                ab.setMessage(msg);
                ab.setView(dlg);
                ab.setNegativeButton("Exit", null);
                ab.show();
            }
        });
    }//onCreate end
}//class END