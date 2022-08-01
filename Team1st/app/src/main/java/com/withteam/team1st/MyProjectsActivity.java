package com.withteam.team1st;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyProjectsActivity extends AppCompatActivity {
    LinearLayout MainLayout, AndroidProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_projects);
        setTitle("내 프로젝트");
        MainLayout = (LinearLayout) findViewById(R.id.MainLayout);
        AndroidProject = (LinearLayout) findViewById(R.id.llAndroidProject);

        FloatingActionButton btnMakeGroup = (FloatingActionButton) findViewById(R.id.btnMakeNew);
        btnMakeGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MakeGroupActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        AndroidProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainFeedActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recruit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curid = item.getItemId();
        switch (curid) {
            case R.id.menu_recruit:
                Intent intent = new Intent(getApplicationContext(), RecruitBoardActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String GroupName = data.getStringExtra("GroupName");
            String GroupPeriod = data.getStringExtra("GroupPeriod");

            // 컨테이너
            LinearLayout LinearGroup = new LinearLayout(this);
            LinearGroup.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = 10;
            LinearGroup.setLayoutParams(param);

            ImageView iv = new ImageView(this);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = 0;
            param.rightMargin = 10;
            iv.setImageResource(R.drawable.api70_resized);
            iv.setMaxWidth(50);
            iv.setMaxHeight(50);
            iv.setLayoutParams(param);

            LinearLayout linear1 = new LinearLayout(this);
            linear1.setOrientation(LinearLayout.VERTICAL);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.topMargin = 0;
            param.rightMargin = 0;
            linear1.setLayoutParams(param);

            LinearLayout linear2 = new LinearLayout(this);
            linear2.setOrientation(LinearLayout.HORIZONTAL);
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 5;
            linear2.setLayoutParams(param);

            TextView tvName = new TextView(getApplicationContext());
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 70;
            tvName.setLayoutParams(param);
            tvName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.crown_resized, 0, 0, 0);
            tvName.setText(GroupName);
            tvName.setTextSize(17);

            TextView tvMembers = new TextView(getApplicationContext());
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 10;
            tvMembers.setLayoutParams(param);
            tvMembers.setCompoundDrawablesWithIntrinsicBounds(R.drawable.user, 0, 0, 0);
            tvMembers.setText("1");

            TextView tvPeriod = new TextView(getApplicationContext());
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 70;
            tvPeriod.setLayoutParams(param);
            tvPeriod.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time_resized, 0, 0, 0);
            tvPeriod.setText("D-" + GroupPeriod);

            linear2.addView(tvName);
            linear2.addView(tvMembers);
            linear2.addView(tvPeriod);

            TextView tvLatestArticle = new TextView(getApplicationContext());
            param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    ,LinearLayout.LayoutParams.WRAP_CONTENT);
            param.bottomMargin = 0;
            param.rightMargin = 0;
            tvLatestArticle.setLayoutParams(param);
            tvLatestArticle.setText("새 그룹을 만들었습니다!");
            tvLatestArticle.setTextSize(15);

            linear1.addView(linear2);
            linear1.addView(tvLatestArticle);

            LinearGroup.addView(iv);
            LinearGroup.addView(linear1);

            MainLayout.addView(LinearGroup);
        }
    }
}