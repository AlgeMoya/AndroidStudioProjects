package com.example.test0105;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cal extends Activity {

    EditText editText;
    TextView textView;

    // 연산자를 저장
    String rule = "";

    // String 형태로 임시 보관하는 변수
    String str = "";

    // 값을 저장하는 변수(최대 2개를 의도한듯)
    float value1, value2, result;

    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        textView = findViewById(R.id.view);
        editText = findViewById(R.id.edit);
        initialize(); // 초기화 함수 호출
        editText.setInputType(0);
    } // onCreate end=====================================================================================

    public void initialize()
    {
        rule="";
        value1 = 0;
        value2 = 0;
        textView.setText("");
        editText.setText("");
    }

    public void num(View vw)
    {
        String strtmp = editText.getText().toString();

        int sel = vw.getId();
        switch (sel)
        {
            case R.id.num0:
                editText.append("0");
                break;
            case R.id.num1:
                editText.append("1");
                break;
            case R.id.num2:
                editText.append("2");
                break;
            case R.id.num3:
                editText.append("3");
                break;
            case R.id.num4:
                editText.append("4");
                break;
            case R.id.num5:
                editText.append("5");
                break;
            case R.id.num6:
                editText.append("6");
                break;
            case R.id.num7:
                editText.append("7");
                break;
            case R.id.num8:
                editText.append("8");
                break;
            case R.id.num9:
                editText.append("9");
                break;
            case R.id.decimal:
                editText.append(".");
                break;
            case R.id.delete:
                int size = strtmp.length();
                String data = strtmp.substring(0, (size-1));
                editText.setText(data);
                break;
            case R.id.allclear:
                initialize(); // 입력란, 결과값, 연산자 초기화
        }
    } // end=====================================================================================

    public void symbol(View vw)
    {
        int sel = vw.getId();

        switch (sel)
        {
            case R.id.add:
                rule="+";
                editText.append("+");
                break;
            case R.id.subtraction:
                rule="-";
                editText.append("-");
                break;
            case R.id.multiply:
                rule="*";
                editText.append("*");
                break;
            case R.id.divide:
                rule="/";
                editText.append("/");
                break;
        }
    } // end=====================================================================================

    public void equal(View vw) // 계산결과
    {
        String strtmp = editText.getText().toString();

        int sel = vw.getId();

        switch (sel)
        {
            case R.id.equal:
                // 문자열 split해야함. 차례대로 조건문으로

                if (rule == "+")
                {
                    // "+"를 구분자로 split해서 첫번째를 value1로, 두번째를 value2로 형변환
                    String[] array = str.split("\\+"); // 특수문자 넣을때 \\ 붙일것!
                    value1 = Float.parseFloat(array[0]);
                    value2 = Float.parseFloat(array[1]);
                    result = value1 + value2;

                    initialize();
                    editText.setText(new Double(result).toString()); // toString하려면 Double 거쳐야 함
                }
                else if (rule == "-")
                {
                    // "+"를 구분자로 split해서 첫번째를 value1로, 두번째를 value2로 형변환
                    String[] array = str.split("-");
                    value1 = Float.parseFloat(array[0]);
                    value2 = Float.parseFloat(array[1]);
                    result = value1 - value2;

                    initialize();
                    editText.setText(new Double(result).toString()); // toString하려면 Double 거쳐야 함
                }
                else if (rule == "*")
                {
                    // "+"를 구분자로 split해서 첫번째를 value1로, 두번째를 value2로 형변환
                    String[] array = str.split("\\*"); // 특수문자 넣을때 \\ 붙일것!
                    value1 = Float.parseFloat(array[0]);
                    value2 = Float.parseFloat(array[1]);
                    result = value1 * value2;

                    initialize();
                    editText.setText(new Double(result).toString()); // toString하려면 Double 거쳐야 함
                }
                else if (rule == "/")
                {
                    // "+"를 구분자로 split해서 첫번째를 value1로, 두번째를 value2로 형변환
                    String[] array = str.split("/");
                    value1 = Float.parseFloat(array[0]);
                    value2 = Float.parseFloat(array[1]);
                    result = value1 / value2;

                    initialize();
                    editText.setText(new Double(result).toString()); // toString하려면 Double 거쳐야 함
                }
                break;
        }

    } // end=====================================================================================
} // Cal class END