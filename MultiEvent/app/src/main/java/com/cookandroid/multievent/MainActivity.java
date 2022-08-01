package com.cookandroid.multievent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 익명의 내부 클래스 리스너 이용 // 상단에 버튼 선언해줘야 함.
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Toast.makeText(getApplicationContext(), "버튼1을 눌렀어요", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        Toast.makeText(getApplicationContext(), "버튼2를 눌렀어요", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
    }

    /* // 위젯의 onClick 속성 이용
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(getApplicationContext(), "버튼1을 눌렀어요", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "버튼2를 눌렀어요", Toast.LENGTH_SHORT).show();
                break;
        }
    }
     */
}