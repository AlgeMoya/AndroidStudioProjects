package com.withteam.team1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MakeGroupActivity extends AppCompatActivity {
    EditText etName, etPeriod;
    Button btnSubmit;
    CheckBox cbUnlimited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_group);
        setTitle("새 그룹 만들기");

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etName = (EditText) findViewById(R.id.etName);
        etPeriod = (EditText) findViewById(R.id.etPeriod);
        cbUnlimited = (CheckBox) findViewById(R.id.cbUnlimited);

        //spinner1
        Spinner spinnerMenu = (Spinner)findViewById(R.id.spinner);
        spinnerMenu.setPrompt("분류");
        final String[] categorization = getResources().getStringArray(R.array.categorization);
        ArrayAdapter menuAdapter = ArrayAdapter.createFromResource(this, R.array.categorization, android.R.layout.simple_spinner_item);
        menuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Spinner 클릭시 DropDown 모양을 설정
        spinnerMenu.setAdapter(menuAdapter); // 스피너에 어댑터를 연결

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("GroupName", etName.getText().toString());
                if (cbUnlimited.isChecked() == true) {
                    outIntent.putExtra("GroupPeriod", "무기한");
                } else {
                    outIntent.putExtra("GroupPeriod", etPeriod.getText().toString());
                }

                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}