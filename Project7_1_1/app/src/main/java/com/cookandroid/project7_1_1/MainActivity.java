package com.cookandroid.project7_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseLayout;
    EditText editText1;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경 보기");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        baseLayout = (RelativeLayout) findViewById(R.id.baseLayout);
        editText1 = (EditText) findViewById(R.id.edittext1);
        imageView1 = (ImageView) findViewById(R.id.imageView01);
        imageView1.setImageResource(R.drawable.jeju1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /* // XML 파일 없이 Java 코드로만 옵션 메뉴 사용하기
        // 메뉴 XML 파일에 접근하는 대신 직접 menu.add() 메소드로 메뉴 항목 추가
        menu.add(0, 1, 0, "배경색(빨강)");
        menu.add(0, 2, 0, "배경색(초록)");
        menu.add(0, 3, 0, "배경색(파랑)");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0, 4, 0, "버튼 45도 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");
         */

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
        // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // XML 대신 Java 코드로 작성했다면 R.id.컴포넌트명 대신 숫자를 쓰면 된다.
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemWhite:
                baseLayout.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.subRotate:
                try {
                    imageView1.setRotation(Integer.parseInt(editText1.getText().toString()));
                    return true;
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력이 잘못되었습니다.", Toast.LENGTH_LONG).show();
                    return true;
                }
            case R.id.subUndo:
                imageView1.setRotation(0);
                imageView1.setScaleX(1);
                return true;
            case R.id.subSize:
                imageView1.setScaleX(2);
                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju_cheonjiyeonfalls);
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju_columnarjoint);
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju_dolharubang);
                return true;
            case R.id.item4:
                imageView1.setImageResource(R.drawable.jeju_jeongbangfalls);
                return true;
            case R.id.item5:
                imageView1.setImageResource(R.drawable.jeju_manjanggul);
                return true;
            case R.id.item6:
                imageView1.setImageResource(R.drawable.jeju_seonujeongsa);
                return true;
            case R.id.item7:
                imageView1.setImageResource(R.drawable.jeju_seopjikoji);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}