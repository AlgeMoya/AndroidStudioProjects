package com.example.board;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity; //추가

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener{

    int cnt = 0 ;
    int[] images = {
            R.drawable.bear,  R.drawable.bbb, R.drawable.bc
    };

    Button btn1,btn2,btn3;
    ImageView iv;

    @Override
    public void onCreate(Bundle bun) {
        super.onCreate(bun);
        setContentView(R.layout.activity_main); // <LL> <버튼> <iv> </LL>

        btn1 = findViewById(R.id.btnMy);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnClose);
        iv = findViewById(R.id.imgMy);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    } // onCreate end

    @Override
    public void onClick(View vw) {
        int sel = vw.getId();
        if(sel == R.id.btnMy ) {
            iv.setImageResource(images[cnt]);
            cnt++;
            if (cnt > 2) {
                cnt = 0;
            }
        }else if(sel == R.id.btnTwo){
            String my_code  ="2400" ;
            String my_title = "snow" ;
            Intent it = new Intent(MainActivity.this, Two.class);
            it.putExtra("code", my_code);
            it.putExtra("title", my_title);
            startActivity(it);
        }else if(sel == R.id.btnClose){
            Toast.makeText(this,"~~~ 닫기 close ~~~ ",Toast.LENGTH_SHORT).show();
            this.finish();
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }
    }//onClick end

    //오른쪽버튼 => Generate... Activity선택후  a-z소트클릭  onCreateOptionsMenu(Menu)메소드선택

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴 생성 이미지, Two, Close
        MenuItem item1 = menu.add(0, 1, 0, "Mimage");
        MenuItem item2 = menu.add(0, 2, 0, "Mtwo");
        MenuItem item3 = menu.add(0, 3, 0, "Mclose");
        return true;
    } // end

    //오른쪽버튼 => Generate... Activity선택후  a-z소트클릭  onOptionsItemSelect(MenuItem)메소드선택
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //int sel = vw.getId();
        int sel = item.getItemId();
        if(sel==1){
            iv.setImageResource(images[cnt]);
            cnt++;
            if (cnt > 2) {
                cnt = 0;
            }
        }else if(sel==2){
            String my_code  ="2400" ;
            String my_title = "snow" ;
            Intent it = new Intent(MainActivity.this, Two.class);
            it.putExtra("code", my_code);
            it.putExtra("title", my_title);
            startActivity(it);
        }else if(sel==3){
            Toast.makeText(this,"~~~ 닫기 close ~~~ ",Toast.LENGTH_SHORT).show();
            this.finish();
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }else{}
        return true;
    }
} //MainActivity class END

// 첫번째  android:onClick="move"  ==>첫번째
// 두번째  btn.setOnClickListener(new View.OnClickListener() { public void onClick(View){ } }
// 3번째  클래스에서 상속받아서 구현 public class MainActivity extends Activity  implements  View.OnClickListener{