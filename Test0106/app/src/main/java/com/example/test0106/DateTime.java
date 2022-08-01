package com.example.test0106;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTime extends Activity {
    Button bt;
    TextView tv1, tv2;
    int year,month,day; //날짜
    int h,m,s ; //시간
    Calendar cal ;

    final int myDate = 1; // 날짜항목상수
    final int myTime = 2; // 시간항목상수

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        bt = findViewById(R.id.button1); // 하단에 move 메소드
        /*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DateTime.this, "aaa", Toast.LENGTH_LONG).show();
            }
        });
        */

        tv1 = findViewById(R.id.et_Birthday);
        tv2 = findViewById(R.id.et_time);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(myDate);
                // onCreateDialog(1);
            }
        });//et1 end

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(myTime);
                // onCreateDialog(2);
                // tv2.setText("timepicker");
            }
        });//et2 end

        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH); //월은 0월부터 시작해서 반드시 +1
        day = cal.get(Calendar.DAY_OF_MONTH);
        h = cal.get(Calendar.HOUR);
        m = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);
        display(); //초기값 지금현재값 출력
    } // onCreate end

    public DatePickerDialog.OnDateSetListener ds = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {
            year = y ;
            month = m ;
            day = d ;
            display();
        }
    };//ds개체화 end

    public TimePickerDialog.OnTimeSetListener ts = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hhh, int mmm) {
            h = hhh;
            m = mmm;
            display();
        }
    }; // ts개체화 end

    // 리턴값은 AlertDialog부모 Dialog타입을 리턴으로 지정
    public Dialog onCreateDialog(int id){ //showDialog()메소드로 접근
        if(id==1) {
            DatePickerDialog dpd = new DatePickerDialog(this, ds, year,m, day); //위젯팩키지 DatePickerDialog클래스 생성자
            return dpd;
        }else if(id==2) {
            TimePickerDialog tpd = new TimePickerDialog(this, ts, h, m, true); //위젯팩키지 DatePickerDialog클래스 생성자
            return tpd; //12시 13시 저녁8시=20
        }
        return null;
    }//onCreateDialog end

    public void display(){
        String msg1 = year + "-" + (month+1) + '-' + day;
        String msg2 = h+":"+m+":" + s;
        tv1.setText(msg1);
        tv2.setText(msg2);
    }//end

    public void move(View vw) {
        int sel = vw.getId();
        if(sel == R.id.button1) {
            // Toast tt = new Toast(this);
            String msg = "성결대 재학생 김영임입니다";
            Toast tt = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            tt.show();
        }
    }

}//DateTIme class END