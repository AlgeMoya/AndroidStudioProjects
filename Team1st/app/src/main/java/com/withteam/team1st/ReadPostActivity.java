package com.withteam.team1st;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReadPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);
        setTitle("글 보기");
    }
}