package com.example.samok;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView info;
    Button bstart, bend;
    Chronometer chrono;
    boolean flag=false;
    int count=0;

    Button[] btnNum = new Button[9];
    int[] btn = {
            R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9
    };

    // 버튼별 소유자를 저장하는 String형 배열
    String[] owner_btn = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.textview);
        bstart = findViewById(R.id.btnstart);
        bend = findViewById(R.id.btnend);
        chrono = findViewById(R.id.chronometer);

        // 버튼들의 소유자를 "none"으로 초기화.
        for (int i=0; i < 9; i++) {
            owner_btn[i] = "none";
        }

        for(int i=0 ; i<9; i++){
            btnNum[i] = findViewById(btn[i]); // 각각의 btnNum을 실제 버튼에 할당한다
            btnNum[i].setText(""); // 버튼의 텍스트를 지우고
            btnNum[i].setEnabled(false);
        }

        //게임시작버튼
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 난수는 여기서는 의미가 없음. 순서가 아니기 때문에

                // 시작 버튼을 누르면
                for(int i=0 ; i<9; i++){
                    btnNum[i].setText(""); // 버튼의 텍스트를 지우고
                    btnNum[i].setEnabled(true); // 버튼을 활성화시킨다
                    btnNum[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) { // 버튼을 클릭하면
                            for(int j=0; j<9; j++) {
                                int sel = view.getId(); // 버튼의 ID를 가져온다
                                if(sel == btn[j]){ // 해당하는 버튼을 찾는다.
                                    if(flag==true){ // flag로 차례를 비교하는 것 같다.
                                        btnNum[j].setBackgroundResource(R.drawable.kg1); // kg1은 턱시도냥이
                                        btnNum[j].setEnabled(false); // 버튼을 비활성화해서 누르지 못하게 한다.
                                        owner_btn[j] = "tuxedo"; // 버튼의 번호에 해당하는 변수에 소유자를 기록한다.
                                        flag=false; // flag를 바꿔서 턴을 넘긴다.

                                        // 여기에 게임 오버 판정 구문 입력
                                        // 012 345 789 037 148 259 049 247
                                        if (owner_btn[0] == "tuxedo" && owner_btn[1] == "tuxedo" && owner_btn[2] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[3] == "tuxedo" && owner_btn[4] == "tuxedo" && owner_btn[5] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[7] == "tuxedo" && owner_btn[8] == "tuxedo" && owner_btn[9] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[0] == "tuxedo" && owner_btn[3] == "tuxedo" && owner_btn[7] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[1] == "tuxedo" && owner_btn[4] == "tuxedo" && owner_btn[8] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[2] == "tuxedo" && owner_btn[5] == "tuxedo" && owner_btn[9] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[0] == "tuxedo" && owner_btn[4] == "tuxedo" && owner_btn[9] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[2] == "tuxedo" && owner_btn[4] == "tuxedo" && owner_btn[7] == "tuxedo") {
                                            info.setText("턱시도냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        }

                                    }else{
                                        btnNum[j].setBackgroundResource(R.drawable.kg6); // kg2는 치즈태비냥이
                                        btnNum[j].setEnabled(false); // 버튼을 비활성화해서 누르지 못하게 한다.
                                        owner_btn[j] = "cheese"; // 버튼의 번호에 해당하는 변수에 소유자를 기록한다.
                                        flag=true; // flag를 바꿔서 턴을 넘긴다.

                                        // 여기에 게임 오버 판정 구문 입력
                                        // 012 345 789 037 148 259 049 247
                                        if (owner_btn[0] == "cheese" && owner_btn[1] == "cheese" && owner_btn[2] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[3] == "cheese" && owner_btn[4] == "cheese" && owner_btn[5] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[7] == "cheese" && owner_btn[8] == "cheese" && owner_btn[9] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[0] == "cheese" && owner_btn[3] == "cheese" && owner_btn[7] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[1] == "cheese" && owner_btn[4] == "cheese" && owner_btn[8] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[2] == "cheese" && owner_btn[5] == "cheese" && owner_btn[9] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[0] == "cheese" && owner_btn[4] == "cheese" && owner_btn[9] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        } else if (owner_btn[2] == "cheese" && owner_btn[4] == "cheese" && owner_btn[7] == "cheese") {
                                            info.setText("치즈태비냥이 승리!");
                                            chrono.stop(); // 크로노미터를 멈추고
                                            for (int k = 0; k < 9; k++) {
                                                btnNum[k].setEnabled(false); // 버튼을 비활성화시킨다.
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }); //btnNum end
                } //for i end

                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();

                /* 제한시간이 없으므로 chronometer에 Listener을 써줄 이유가 없다.
                //크로노미터 TickListener
                chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        String sCurrentTime = chronometer.getText().toString();
                        if(sCurrentTime.equals("경과시간:00:10")){ // 경과시간이 10초를 넘으면
                            chrono.stop(); // 시간을 그만 세고
                            for(int k=0; k<9; k++){btnNum[k].setEnabled(false);} // 버튼을 모두 비활성화한다
                        }
                    }
                });//크로노미터 end */

                // for(int k=0; k<9; k++){btnNum[k].setEnabled(true);}
            }//on Click end
        });//bstart end

        //게임종료
        bend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 종료 버튼을 누르면
                chrono.stop(); // 크로노미터를 멈추고
                for(int i=0; i<9; i++) {
                    btnNum[i].setBackgroundResource(android.R.drawable.btn_default); // 버튼 초기화시키고
                    btnNum[i].setEnabled(false); // 버튼을 비활성화시킨다.
                    owner_btn[i] = "none"; // 소유권 저장하는 변수를 모두 "none"으로 초기화한다.
                    // 여기에 상단 문구 초기화 구문 입력.
                } // 크로노미터는 이 정도면 됐다.
            }
        });//bend end

    }//onCreate end

}//Samok class END

// 무식하게 한 거 같네요. 죄송합니다 ㅠㅠ