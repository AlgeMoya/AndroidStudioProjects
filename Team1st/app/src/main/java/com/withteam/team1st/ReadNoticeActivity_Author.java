package com.withteam.team1st;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadNoticeActivity_Author extends AppCompatActivity {
    TextView tvName, tvPerson, tvDday, tvPeriod, tvLocation, tvDescription;
    Button btnAccpet, btnReject, btnFinish, btnDelete;
    LinearLayout llRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_notice_author);
        setTitle("모집 상세확인");

        tvName = (TextView) findViewById(R.id.tvName);
        tvPerson = (TextView) findViewById(R.id.tvPerson);
        tvDday = (TextView) findViewById(R.id.tvDday);
        tvPeriod = (TextView) findViewById(R.id.tvPeriod);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        btnAccpet = (Button) findViewById(R.id.btnAccept);
        btnReject = (Button) findViewById(R.id.btnReject);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        llRequest = (LinearLayout) findViewById(R.id.llRequest);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String NoticeName = intent.getStringExtra("NoticeName");
        String CurrentPerson = intent.getStringExtra("CurrentPerson");
        String MaxPerson = intent.getStringExtra("MaxPerson");
        String Dday = intent.getStringExtra("Dday");
        String StartDate = intent.getStringExtra("StartDate");
        String EndDate = intent.getStringExtra("EndDate");
        String Location = intent.getStringExtra("Location");
        String Description = intent.getStringExtra("Description");

        tvName.setText(NoticeName);
        tvPerson.setText("등록: "+ CurrentPerson +" / 전체: " + MaxPerson + "명");
        tvDday.setText("모집기간: " + Dday + "까지");
        tvPeriod.setText("진행기간: " + StartDate + " ~ " + EndDate);
        tvLocation.setText("장소: " + Location);
        tvDescription.setText(Description);

        btnAccpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llRequest.removeAllViews();
                tvPerson.setText("등록: "+ CurrentPerson + 1 +" / 전체: " + MaxPerson + "명");
                AlertDialog.Builder dlg = new AlertDialog.Builder(ReadNoticeActivity_Author.this);
                dlg.setTitle("승인 완료");
                dlg.setMessage("승인 완료했습니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llRequest.removeAllViews();
                AlertDialog.Builder dlg = new AlertDialog.Builder(ReadNoticeActivity_Author.this);
                dlg.setTitle("승인 거부");
                dlg.setMessage("승인 거부했습니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}