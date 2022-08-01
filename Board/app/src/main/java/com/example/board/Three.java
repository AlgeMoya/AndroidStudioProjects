package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    } // end

    public void buttonClick1(View ew) // 네이버접속
    {
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        startActivity(it);
    } // end

    public void buttonClick2(View ew) // 전화걸기
    {
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-6789-1234"));
        startActivity(it);
    } // end

    public void buttonClick3(View ew)
    {
        String msg = "메인화면으로 이동합니다";
        Toast tt = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        tt.show();

        MainActivity main = new MainActivity(); // 액티비티 화면이동은 반드시 Intent 통해서 이동
        Intent it = new Intent(Three.this, MainActivity.class);
        startActivity(it);
    } // end

} // Three class END