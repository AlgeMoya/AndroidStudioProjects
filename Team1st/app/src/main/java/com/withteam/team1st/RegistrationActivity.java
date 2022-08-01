package com.withteam.team1st;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("회원가입");

        EditText etID = (EditText) findViewById(R.id.etID);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etNickname = (EditText) findViewById(R.id.etNickname);
        EditText etPhonenumber = (EditText) findViewById(R.id.etPhonenumber);

        Button btnAuth = (Button) findViewById(R.id.btnAuth);

        CheckBox cbTerm = (CheckBox) findViewById(R.id.cbTerm);
        TextView tvTerm = (TextView) findViewById(R.id.tvTerm);

        Button btnRegistration = (Button) findViewById(R.id.btnRegistration);


        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(RegistrationActivity.this);
                dlg.setTitle("인증 완료");
                dlg.setMessage("휴대폰 번호가 인증되었습니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        cbTerm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbTerm.isChecked() == true) {
                    cbTerm.setChecked(false);
                }
                if (cbTerm.isChecked() == false) {
                    cbTerm.setChecked(true);
                }
            }
        });

        tvTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbTerm.isChecked() == true) {
                    cbTerm.setChecked(false);
                }
                if (cbTerm.isChecked() == false) {
                    cbTerm.setChecked(true);
                }
            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}