package com.cookandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10]; // 버튼도 배열로 선언 가능
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnMod = (Button) findViewById(R.id.BtnMod);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else if (edit2.getText().toString().equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        btnMod.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else if (edit2.getText().toString().equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });

        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]); // numBtnIDs 배열의 원소로는 XML 파일의 버튼들이 저장되어 있다. 따라서 해당 배열을 참조해서 반복문으로 버튼을 할당할 수 있다.
        }

        for (i = 0; i < numBtnIDs.length; i++) {
            final int index; // 주의! 꼭 필요함
            index = i; // index에 순서에 맞는 버튼 번호를 넣어준다.

            // 버튼 리스너 반복문으로 자동생성
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused() == true) { // 에디트텍스트가 선택되었는지 판단 가능
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString(); // 텍스트 + 하면 이어붙는 걸 이용해서 String형의 num1에 새로 누른 숫자를 이어붙여서 저장
                        edit1.setText(num1); // 그렇게 이어붙여서 저장한 num1의 값을 에디트텍스트로 다시 반영시킴
                    } else if (edit2.isFocused() == true) { // 이거 없으면 어느 에디트텍스트에 입력을 원하는지 판단 불가
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show(); //
                    }
                }
            });
        }
    }
}