package com.withteam.team1st;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MemberManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_management);
        setTitle("그룹 멤버 관리");
    }
}