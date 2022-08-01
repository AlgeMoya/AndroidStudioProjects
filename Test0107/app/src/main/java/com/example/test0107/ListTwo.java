package com.example.test0107;

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

        // al = new ArrayList<Fruit>(); // 위에서 이미 초기화했음
        al.add(new Fruit(R.drawable.melon,"메론",false, "2021.09.02"));
        al.add(new Fruit(R.drawable.lemon,"레몬",true, "2021.12.21"));
        al.add(new Fruit(R.drawable.jadoo,"자두",true, "2022.01.03"));
        al.add(new Fruit(R.drawable.singer4,"소냐",false, "2021.10.08"));
        al.add(new Fruit(R.drawable.cherry,"체리",true, "2022.01.12"));
        al.add(new Fruit(R.drawable.banana,"바나나",false, "2021.12.08"));

        //ArrayAdapter dap = new ArrayAdapter(ListTwo.this, android.R.layout.simple_spinner_dropdown_item, al);
        dap = new KakaoAdapter(this, R.layout.kakao, al );
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