package com.withteam.team1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MakeNoticeActivity extends AppCompatActivity {
    String WorkMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_notice);
        setTitle("모집 글쓰기");

        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");

        EditText etNoticeName = (EditText) findViewById(R.id.etNoticeName);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        EditText etLocation = (EditText) findViewById(R.id.etLocation);
        EditText etDday = (EditText) findViewById(R.id.etDday);
        EditText etStartDate = (EditText) findViewById(R.id.etStartDate);
        EditText etEndDate = (EditText) findViewById(R.id.etEndDate);
        EditText etUniv = (EditText) findViewById(R.id.etSchool);
        EditText etDescription = (EditText) findViewById(R.id.etDescription);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //spinner1
        Spinner spinnerMenu = (Spinner)findViewById(R.id.spinner);
        spinnerMenu.setPrompt("분류");
        final String[] categorization = getResources().getStringArray(R.array.categorization);
        ArrayAdapter menuAdapter = ArrayAdapter.createFromResource(this, R.array.categorization, android.R.layout.simple_spinner_item);
        menuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Spinner 클릭시 DropDown 모양을 설정
        spinnerMenu.setAdapter(menuAdapter); // 스피너에 어댑터를 연결

        //spinner2
        Spinner spinnerMenu2 = (Spinner)findViewById(R.id.spinner2);
        spinnerMenu2.setPrompt("인원수");
        final String[] categorization2 = getResources().getStringArray(R.array.categorization2);
        ArrayAdapter menuAdapter2 = ArrayAdapter.createFromResource(this, R.array.categorization2, android.R.layout.simple_spinner_item);
        menuAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Spinner 클릭시 DropDown 모양을 설정
        spinnerMenu2.setAdapter(menuAdapter2); // 스피너에 어댑터를 연결

        //spinner3
        Spinner spinnerMenu3 = (Spinner)findViewById(R.id.spinner3);
        spinnerMenu3.setPrompt("학과");
        final String[] categorization3 = getResources().getStringArray(R.array.categorization3);
        ArrayAdapter menuAdapter3 = ArrayAdapter.createFromResource(this, R.array.categorization3, android.R.layout.simple_spinner_item);
        menuAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Spinner 클릭시 DropDown 모양을 설정
        spinnerMenu3.setAdapter(menuAdapter3); // 스피너에 어댑터를 연결

        //spinner3
        Spinner spinnerMenu4 = (Spinner)findViewById(R.id.spinner4);
        spinnerMenu4.setPrompt("학년");
        final String[] categorization4 = getResources().getStringArray(R.array.categorization4);
        ArrayAdapter menuAdapter4 = ArrayAdapter.createFromResource(this, R.array.categorization4, android.R.layout.simple_spinner_item);
        menuAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Spinner 클릭시 DropDown 모양을 설정
        spinnerMenu4.setAdapter(menuAdapter4); // 스피너에 어댑터를 연결

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Contact:
                        WorkMethod = "대면";
                        break;
                    case R.id.Untact:
                        WorkMethod = "비대면";
                        break;
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "님, 환영합니다.", Toast.LENGTH_SHORT).show();
                Intent outIntent = new Intent(getApplicationContext(), RecruitBoardActivity.class);
                outIntent.putExtra("ID", ID);
                outIntent.putExtra("NoticeName", etNoticeName.getText().toString());
                outIntent.putExtra("Location", etLocation.getText().toString());
                outIntent.putExtra("Department1", spinnerMenu.getSelectedItem().toString());
                outIntent.putExtra("WorkMethod", WorkMethod);
                outIntent.putExtra("Person", spinnerMenu2.getSelectedItem().toString());
                outIntent.putExtra("Dday", etDday.getText().toString());
                outIntent.putExtra("StartDate", etStartDate.getText().toString());
                outIntent.putExtra("EndDate", etEndDate.getText().toString());
                outIntent.putExtra("Univ", etUniv.getText().toString());
                outIntent.putExtra("Department2", spinnerMenu3.getSelectedItem().toString());
                outIntent.putExtra("Grade", spinnerMenu4.getSelectedItem().toString());
                outIntent.putExtra("Description", etDescription.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}