package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    DBManager  dbmgr;
    SQLiteDatabase  sdb;
    Cursor cs; // select 필드1,필드2  from guest; 조회한결과값을 기억 레코드셋=리절트셋=데이트셋

    Button btn1, btn2;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_insert);
        btn2 = findViewById(R.id.btn_delete);
        layout = findViewById(R.id.customers);
        int cnt = 0;

        try {
            dbmgr = new DBManager(this);
            sdb = dbmgr.getReadableDatabase(); // 읽기 전용
            // sdb.execSQL("delete from guest;");
            // guest(name text, gender text, sms text)
            cs = sdb.rawQuery("select * from guest;", null);

            while (cs.moveToNext() == true) {
                String name = cs.getString(0);
                String gender = cs.getString(1);
                String sms = cs.getString(2);

                TextView tv1 = new TextView(this);
                tv1.append(name + " ");
                tv1.setTextSize(24);
                tv1.setBackgroundColor(Color.LTGRAY);
                layout.addView(tv1);

                // 문자열위젯 getText(), setText(), append()
                TextView tv2 = new TextView(this);
                tv2.append(gender + "  ");
                tv2.append(sms + "\n");
                tv2.setTextSize(24);
                layout.addView(tv2);
                cnt++;
            } // while end

            if (cnt == 0) {
                TextView tv7 = new TextView(this);
                tv7.setText("등록된 데이터가 없습니다");
                tv7.setTextSize(24);
                layout.addView(tv7);
            }
            cs.close();
            dbmgr.close();

        } catch (Exception ex) {
            TextView tv_err = new TextView(this);
            tv_err.setText("db처리 에러 : " + ex.toString());
            tv_err.setTextColor(Color.RED);
            tv_err.setTextSize(16);
            layout.addView(tv_err);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Customer.class);
                startActivity(it);
            }
        }); // btn1 end
    } // onCreate end
} // MainActivity class END