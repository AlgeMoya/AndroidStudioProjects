package com.cookandroid.fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    Button btnNate, btn119, btnGal, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        btnNate = (Button)findViewById(R.id.btnNate);
        btn119 = (Button)findViewById(R.id.btn119);
        btnGal = (Button)findViewById(R.id.btnGal);
        btnEnd = (Button)findViewById(R.id.btnEnd);

        btnNate.setBackgroundColor(Color.GRAY);
        btn119.setBackgroundColor(Color.GREEN);
        btnGal.setBackgroundColor(Color.RED);
        btnEnd.setBackgroundColor(Color.YELLOW);

        btnNate.setTextColor(Color.BLACK);
        btn119.setTextColor(Color.BLACK);
        btnGal.setTextColor(Color.BLACK);
        btnEnd.setTextColor(Color.BLACK);

        btnNate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 선언. URL을 보냄.
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                // URL을 담은 인텐트라고만 선언했는데도 웹 연결이라고 적절히 판단해서 웹 브라우저를 띄워줌.
                startActivity(mintent);
            }
        });

        btn119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 선언. 전화번호를 보냄.
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"));
                // 전화번호를 담은 인텐트를 받으면 전화 연결이라고 적절히 판단해서 다이얼러를 띄워줌.
                startActivity(mintent);
            }
        });

        // 아래 버튼 2개는 숙제! 책에 소스코드가 나와있음
        btnGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 선언. 기본 이미지 뷰어를 호출함
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                // 기기에 설정된 기본 이미지 뷰어를 호출해서 띄워줌.
                startActivity(mintent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 애플리케이션 종료
            }
        });
    }
}