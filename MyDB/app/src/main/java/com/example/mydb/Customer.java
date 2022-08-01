package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Customer extends AppCompatActivity {
    DBManager dbmgr;
    SQLiteDatabase sdb;
    Button btn1, btn2;
    CheckBox cb;
    RadioGroup radioGroup;
    EditText et;
    String str_name = "", str_gender = "", str_sms = "", msg = "", sql = ""; // Structured Query Language

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        btn1 = findViewById(R.id.button_store);
        btn2 = findViewById(R.id.button_main);
        cb = findViewById(R.id.check_sms);
        radioGroup = findViewById(R.id.radiogroup_gender);
        et = findViewById(R.id.edit_name);

        dbmgr = new DBManager(this);
        sdb = dbmgr.getWritableDatabase(); // 쓰기 기록, 즉 저장

        btn1.setOnClickListener(new View.OnClickListener() { // 저장처리
            @Override
            public void onClick(View view) {
                // 이름, 성별, 체크박스
                str_name = et.getText().toString();
                if (radioGroup.getCheckedRadioButtonId() == R.id.radio_man) {
                    str_gender = "남자";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radio_woman) {
                    str_gender = "여자";
                } else {

                }

                str_sms = (String)cb.getText();
                // System.out.println(str_name + "  " + str_gender + "  " + str_sms  + "    선택 메시지 확인");
                // RDB-Oracle, MySQL, MariaDB, MS SQL Server, 티맥스 Tibero ===> 문자 데이터 알맹이
                msg = "insert into guest values ( '"+str_name+"', '"+str_gender+"', '"+str_sms+"');";
                System.out.println(msg);

                sdb.execSQL(msg); // 실제 실행
                System.out.println("guest Table 저장 성공했습니다.");
                dbmgr.close();

                Intent it = new Intent(Customer.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }); // btn1 end

        btn2.setOnClickListener(new View.OnClickListener() { // main 화면 복귀
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Customer.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }); // btn2 end

    } // onCreate end
} // class END