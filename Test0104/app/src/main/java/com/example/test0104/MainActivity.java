package com.example.test0104;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {
    TextView tv1,tv2;
    EditText et;
    Button btn;
    TextWatcher tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tvDate) ;
        tv2 = findViewById(R.id.tvRate) ;
        et = findViewById(R.id.editText1);
        btn = findViewById(R.id.button1);

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일 hh:mm:ss");
        String display = sdf.format(dt);
        tv1.setText(display);

        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                String message ="환율결과값 삭제합니다";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                tv2.setText(""); // 공백없이 초기화하세요
                et.setText("");
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                // 리턴값이 없으니까 void라도 편하죠
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                // 여기에 코드 기술
                try {
                    String str = et.getText().toString();
                    int data = Integer.parseInt(str);
                    int ret = data * 100;
                    SimpleDateFormat sdf2 = null;
                    DecimalFormat df = new DecimalFormat("#,###");
                    tv2.setText(df.format(ret) + "원");
                }catch (Exception ex){}
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                // 리턴값이 없으니까 void라도 편하죠
            }
        });


    }
}//class END
