package com.example.day0111;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Listviewitem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        list = new ArrayList<Listviewitem>();

        // 자바의 순수클래스 객체화생성
        Listviewitem lion = new Listviewitem(R.drawable.lion, "라이언");
        Listviewitem tiger = new Listviewitem(R.drawable.tiger, "타이거");
        Listviewitem dog = new Listviewitem(R.drawable.dog, "강아지");
        Listviewitem cat = new Listviewitem(R.drawable.cat, "고양이");
        list.add(lion);
        list.add(tiger);
        list.add(dog);
        list.add(cat);

        // ArrayAdapter 대신 새로운 ListviewAdapter 어댑터 생성
        // public ListviewAdapter(Context context, int layout, ArrayLit<Listviewitem> data);
        // ArrayAdapter dap = null;
        ListviewAdapter dap = new ListviewAdapter(this, R.layout.listview_item, list);
        lv.setAdapter(dap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Listviewitem item = (Listviewitem)dap.data.get(pos);
                String msg = item.name + " 동물을 사랑합니다"; // name
                int num = item.icon; // 아이콘

                View dlg = View.inflate(MainActivity.this, R.layout.display, null);
                ImageView poster = dlg.findViewById(R.id.ivPoster);
                poster.setImageResource(num);

                AlertDialog.Builder ab = new AlertDialog.Builder(adapterView.getContext());
                ab.setTitle("월요일오후");
                ab.setIcon(R.drawable.kg5);
                ab.setMessage(msg);
                ab.setView(dlg);
                ab.setNegativeButton("close", null);
                ab.show();
            }
        });

        // lv에 출력 동물아이콘, 동물이름 setAdapter()
        // lv에 항목 선택하면 AlertDialog.Builder에 선택한 동물, 이름 출력 ==> 이벤트
        // Test0109 플젝 분석해서 lv 위젯에 데이터 뿌리기
    } // onCreate end
} // class END