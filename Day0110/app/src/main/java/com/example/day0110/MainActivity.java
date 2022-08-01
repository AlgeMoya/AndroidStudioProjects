package com.example.day0110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        lv = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
            list.add("오렌지");
            list.add("토마토");
            list.add("바나나");
            list.add("복숭아");
            list.add("한라봉");
            list.add("천혜향");
            list.add("청포도");

            // 문제 1: 과일 항목 데이터 list를 lv에다가 추가시켜서 출력하는 ArrayAdapter 클래스
            // ArrayAdapter dap = new ArrayAdapter(this, user레이아웃생서, list항목에 대한 내용을 class);
            ArrayAdapter dap = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
            // 동물그림 출력
            lv.setAdapter(dap);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    tv.setText(list.get(pos).toString()); // tv대신 AlertDialog.Builder ab = new ~~
                }
            });
    } // onCreate end
} // Class END