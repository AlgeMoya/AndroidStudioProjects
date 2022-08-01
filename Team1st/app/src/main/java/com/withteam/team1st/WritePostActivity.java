package com.withteam.team1st;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WritePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);
        setTitle("글쓰기");
    }
}