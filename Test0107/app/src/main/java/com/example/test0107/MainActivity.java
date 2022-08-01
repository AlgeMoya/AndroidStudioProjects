package com.example.test0107;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2, sp3;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spinner1);
        // ArrayAdapter dap1 = ArrayAdapter.createFromResource(Context1, int2, int3);
        // ArrayAdapter dap1 = ArrayAdapter.createFromResource(Activity참조, 자원항목데이터, 스타일);
        ArrayAdapter dap1 = ArrayAdapter.createFromResource(this, R.array.hobby, android.R.layout.simple_spinner_dropdown_item);
        // dap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(dap1);

        // sp2컴포넌트 = 위젯
        sp2 = findViewById(R.id.spinner2); // 아래참조
        ArrayAdapter dap2 = ArrayAdapter.createFromResource(this, R.array.my, android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(dap2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) { // (1, 2, 3, 4)
                // TextView tv = new TextView();
                TextView tv = (TextView)adapterView.getChildAt(0); // 정답
                Log.d("testyoung", "aaaaaaaaaa 11:20분 2교시");
                System.out.println("bbbbbbbbb 11:20분 2교시");
                // 콘솔창의 내용은 Logcat에서 볼 수 있다.
                tv.setTextColor(Color.BLUE);
                tv.setTextSize(24);
            } // end

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); // sp2 end

        // sp3컴포넌트 = 위젯
        ArrayList<String> list = new ArrayList<String>();
        list.add("둘리");
        list.add("도우너");
        list.add("고길동");
        list.add("마이콜");
        sp3 = findViewById(R.id.spinner3); // 아래참조
        // ArrayAdapter dap3 = new ArrayAdapter(1액티비티연결, 2스타일, 3데이터);
        ArrayAdapter dap3 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item);
        // ArrayAdapter dap3 = ArrayAdapter.createFromResource(this, R.array.my, android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(dap3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) { // (1, 2, 3, 4)
                // TextView tv = new TextView();
                // TextView tv = (TextView)adapterView.getChildAt(0); // 정답
                // Log.d("testyoung", "aaaaaaaaaa 11:20분 2교시");
                // System.out.println("bbbbbbbbb 11:20분 2교시");
                // 콘솔창의 내용은 Logcat에서 볼 수 있다.

                // tv.setTextSize(24);
                String data = adapterView.getItemAtPosition(pos).toString();
                TextView tv = new TextView(MainActivity.this);
                // tv.setText(data);
                // tv.setTextColor(Color.RED); // 컬러 먹일려면 getChildAt으로 해야 함
                // System.out.println("adapterView.getItemAtPosition(pos).toString() = " + data);
            } // end

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); // sp3 end
    } // onCreate end
} // class END