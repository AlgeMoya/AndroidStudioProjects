package com.example.day0113;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnstart);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent 클래스 = Activity 클래스 + Service 클래스 연결하는 역할
                Intent it = new Intent(getApplicationContext(), MyService.class);
                startService(it);
            }
        }); // btn1 end

        btn2 = findViewById(R.id.btnend);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MyService.class);
                stopService(it);
            }
        }); // btn2 end
    } // onCreate end
} // class END