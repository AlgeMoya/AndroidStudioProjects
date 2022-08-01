package com.cookandroid.project_4_2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switchAgree;
    // CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoS, rdoR, rdoQ, rdoPie, rdoOreo, rdoNougat, rdoMarshmallow, rdoLollipop;
    Button btnEnd, btnDefault;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        text1 = (TextView) findViewById(R.id.Text1);
        // chkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        switchAgree = (Switch) findViewById(R.id.SwitchAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoS = (RadioButton) findViewById(R.id.RdoS);
        rdoR = (RadioButton) findViewById(R.id.RdoR);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        rdoPie = (RadioButton) findViewById(R.id.RdoPie);
        rdoOreo = (RadioButton) findViewById(R.id.RdoOreo);
        rdoNougat = (RadioButton) findViewById(R.id.RdoNougat);
        rdoMarshmallow = (RadioButton) findViewById(R.id.RdoMarshmallow);
        rdoLollipop = (RadioButton) findViewById(R.id.RdoLollipop);

        btnEnd = (Button) findViewById(R.id.BtnEnd);
        btnDefault = (Button) findViewById(R.id.BtnDefault);
        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

        /*
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    imgAndroid.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    imgAndroid.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
         */

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switchAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnEnd.setVisibility(android.view.View.VISIBLE);
                    btnDefault.setVisibility(android.view.View.VISIBLE);
                    imgAndroid.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnEnd.setVisibility(android.view.View.INVISIBLE);
                    btnDefault.setVisibility(android.view.View.INVISIBLE);
                    imgAndroid.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoS:
                        imgAndroid.setImageResource(R.drawable.s300);
                        break;
                    case R.id.RdoR:
                        imgAndroid.setImageResource(R.drawable.r300);
                        break;
                    case R.id.RdoQ:
                        imgAndroid.setImageResource(R.drawable.q10);
                        break;
                    case R.id.RdoPie:
                        imgAndroid.setImageResource(R.drawable.pie);
                        break;
                    case R.id.RdoOreo:
                        imgAndroid.setImageResource(R.drawable.oreo);
                        break;
                    case R.id.RdoNougat:
                        imgAndroid.setImageResource(R.drawable.nougat);
                        break;
                    case R.id.RdoMarshmallow:
                        imgAndroid.setImageResource(R.drawable.marshmallow);
                        break;
                    case R.id.RdoLollipop:
                        imgAndroid.setImageResource(R.drawable.lollipop);
                        break;
                    default:
                        if (switchAgree.isChecked() == true) {
                            Toast.makeText(getApplicationContext(), "버전을 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 애플리케이션 종료
            }
        });

        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchAgree.setChecked(false);
                rGroup1.clearCheck();
                imgAndroid.setImageResource(0);
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                btnEnd.setVisibility(android.view.View.INVISIBLE);
                btnDefault.setVisibility(android.view.View.INVISIBLE);
                imgAndroid.setVisibility(android.view.View.INVISIBLE);
            }
        });
    }
}