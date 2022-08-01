package com.example.board;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Two extends Activity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tv1 = findViewById(R.id.tv_code);
        tv2 = findViewById(R.id.tv_title);
        Intent tt = this.getIntent();
        String a = tt.getStringExtra("code");
        String b = tt.getStringExtra("title");
        tv1.setText(a);
        tv2.setText(b);
    }
} // Two class END