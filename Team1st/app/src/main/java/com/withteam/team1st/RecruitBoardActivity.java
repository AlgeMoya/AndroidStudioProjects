package com.withteam.team1st;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecruitBoardActivity extends AppCompatActivity {
    ArrayList<Notice> notices = new ArrayList<Notice>();
    Notice notice;
    int indextemp;
    String ID, NoticeName, Location, Department1, WorkMethod, CurrentPerson, MaxPerson, Dday, StartDate, EndDate, Univ, Department2, Grade, Description;
    LinearLayout MainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit_board);
        setTitle("모집");

        MainLayout = (LinearLayout) findViewById(R.id.MainLayout);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");

        FloatingActionButton btnWriteNew = (FloatingActionButton) findViewById(R.id.btnWriteNew);
        btnWriteNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MakeNoticeActivity.class);
                intent.putExtra("ID", ID);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curid = item.getItemId();
        switch (curid) {
            case R.id.menu_myproject:
                Intent intent = new Intent(getApplicationContext(), MyProjectsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            notice = new Notice(data.getStringExtra("ID"), data.getStringExtra("NoticeName"), data.getStringExtra("Location"), data.getStringExtra("Department1"),
                    data.getStringExtra("WorkMethod"), "1", data.getStringExtra("Person"), data.getStringExtra("Dday"), data.getStringExtra("StartDate"), data.getStringExtra("EndDate"),
                    data.getStringExtra("Univ"), data.getStringExtra("Department2"), data.getStringExtra("Grade"), data.getStringExtra("Description"));
            notices.add(notice);

            // 컨테이너
            LinearLayout LinearNotice = new LinearLayout(this);
            LinearNotice.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 15;
            LinearNotice.setLayoutParams(param);

            // 모집중, 분류, 지역
            LinearLayout linearline1 = new LinearLayout(this);
            linearline1.setOrientation(LinearLayout.HORIZONTAL);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 3;
            linearline1.setLayoutParams(param);

            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 10;

            // 모집중
            TextView textViewNoticeState = new TextView(getApplicationContext());
            textViewNoticeState.setText("모집중");
            textViewNoticeState.setLayoutParams(param);

            // 분류
            TextView textViewNoticeDepartment = new TextView(getApplicationContext());
            textViewNoticeDepartment.setText(notice.Department1);
            textViewNoticeDepartment.setLayoutParams(param);

            // 지역
            TextView textViewNoticeLocation = new TextView(getApplicationContext());
            textViewNoticeLocation.setText(notice.Location);
            textViewNoticeLocation.setLayoutParams(param);

            linearline1.addView(textViewNoticeState);
            linearline1.addView(textViewNoticeDepartment);
            linearline1.addView(textViewNoticeLocation);

            // 제목
            LinearLayout linearline2 = new LinearLayout(this);
            linearline2.setOrientation(LinearLayout.HORIZONTAL);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.rightMargin = 0;
            param.bottomMargin = 3;
            linearline2.setLayoutParams(param);

            TextView textViewNoticeName = new TextView(getApplicationContext());
            textViewNoticeName.setText(notice.NoticeName);

            linearline2.addView(textViewNoticeName);

            // 인원, 기한
            LinearLayout linearline3 = new LinearLayout(this);
            linearline3.setOrientation(LinearLayout.HORIZONTAL);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 10;
            linearline3.setLayoutParams(param);

            // 인원
            TextView textViewNoticePerson = new TextView(getApplicationContext());
            textViewNoticePerson.setText(notice.CurrentPerson + "/" + notice.MaxPerson);
            textViewNoticePerson.setCompoundDrawablesWithIntrinsicBounds( R.drawable.user, 0, 0, 0);
            textViewNoticePerson.setLayoutParams(param);

            // 기한
            TextView textViewNoticeDday = new TextView(getApplicationContext());
            textViewNoticeDday.setText("~" + notice.Dday);
            textViewNoticeDday.setCompoundDrawablesWithIntrinsicBounds( R.drawable.user, 0, 0, 0);
            textViewNoticeDday.setLayoutParams(param);

            linearline3.addView(textViewNoticePerson);
            linearline3.addView(textViewNoticeDday);

            LinearNotice.addView(linearline1);
            LinearNotice.addView(linearline2);
            LinearNotice.addView(linearline3);
            LinearNotice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ReadNoticeActivity_Author.class);
                    for (int i = 0; i < notices.size(); i++) {
                        if (notices.get(i).NoticeName == notice.NoticeName) {
                            indextemp = i;
                        }
                    }

                    intent.putExtra("ID", ID);
                    intent.putExtra("NoticeName", notices.get(indextemp).NoticeName);
                    intent.putExtra("CurrentPerson", notices.get(indextemp).CurrentPerson);
                    intent.putExtra("MaxPerson", notices.get(indextemp).MaxPerson);
                    intent.putExtra("Dday", notices.get(indextemp).Dday);
                    intent.putExtra("StartDate", notices.get(indextemp).StartDate);
                    intent.putExtra("EndDate", notices.get(indextemp).EndDate);
                    intent.putExtra("Location", notices.get(indextemp).Location);
                    intent.putExtra("Description", notices.get(indextemp).Description);
                    startActivityForResult(intent, 0);
                }
            });

            MainLayout.addView(LinearNotice);
        }
    }
}