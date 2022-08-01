package com.example.test0105;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    TextView tv1, tv2, tv3;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    RadioGroup radioG;
    RadioButton rb1, rb2;
    ImageView iv1, iv2;
    Button btn1, btn2;
    LinearLayout LL;
    ToggleButton tButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);

        tv1 = findViewById(R.id.textView1); // 체크박스 출력결과
        tv2 = findViewById(R.id.textView2); // 라디오 출력결과


        radioG = findViewById(R.id.radioGroup1);
        rb1 = findViewById(R.id.rbMan);
        rb2 = findViewById(R.id.rbWoman);

        // LL = findViewById(R.id.checkboxLinearLayout);
        // LL.setBackgroundColor(R.drawable.);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);

        rb1.setOnCheckedChangeListener(this);
        rb2.setOnCheckedChangeListener(this);

        // RadioGroup, RadioButton 검색해서 이벤트처리
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGrouproup, int id) {
                // int i 대신 id로 변경
                switch (id)
                {
                    case R.id.rbMan:
                        tv2.setText("남자 신사분입니다.");
                        break;
                    case R.id.rbWoman:
                        tv2.setText("여자 숙녀분입니다.");
                        break;
                }
            }
        });

        tv3 = findViewById(R.id.textView3);
        tButton = findViewById(R.id.toggleButton1); // 午後でここから始める！
        tButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean flag) {
                if (flag == true)
                {
                    tv3.setText("피자 커피 사과 도너츠");
                }
                else
                {
                    tv3.setText("Pizza Coffee Apple Doughnuts");
                }
            }
        });

    } // onCreate end

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";

        if (cb1.isChecked() == true)
            message += " Red, ";
        else if (cb2.isChecked() == true)
            message += " Blue, ";
        else if (cb3.isChecked() == true)
            message += " Green, ";
        else if (cb4.isChecked() == true)
            message += " Orange, ";
        else if (cb5.isChecked() == true)
            message += " Pink, ";
        else { }

        tv1.setText(message);
    }
} // MainActivity Class END