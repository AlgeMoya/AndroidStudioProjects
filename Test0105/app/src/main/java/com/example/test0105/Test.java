package com.example.test0105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test extends AppCompatActivity {
    Button btn;
    boolean flag = false;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn = findViewById(R.id.btnPicture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //apple.png, lemon.png
                int sel = view.getId(); //3시에 시작
                btn.setText("");
                if(flag==true) {
                    btn.setBackgroundResource(R.drawable.apple);
                    btn.setText("O");
                    btn.setTextSize(34);
                    flag = false;
                }else{
                    btn.setBackgroundResource(R.drawable.lemon);
                    btn.setText("X");
                    btn.setTextSize(34);
                    flag = true;
                }
                count++;
                if(count==6){
                    //그림삭제...
                    btn.setBackgroundResource(0);
                    btn.setText(" ");
                }
            }
        });//btn END

    }//onCreate end
}//Test class END