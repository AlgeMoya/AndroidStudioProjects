package com.withteam.team1st;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FileListActivity extends AppCompatActivity {
    // Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);
        setTitle("모바일프로그래밍 파일 모아보기");

        BottomNavigationView bottomMenu = (BottomNavigationView) findViewById(R.id.bottomMenu);
        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feed:
                        Intent intent = new Intent(getApplicationContext(), MainFeedActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.schedule:
                        // intent = new Intent(getApplicationContext(), ScheduleActivity.class);
                        // startActivity(intent);
                        return true;
                    case R.id.file:
                        return true;
                }
                return false;
            }
        });
    }
}