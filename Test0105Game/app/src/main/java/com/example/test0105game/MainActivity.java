package com.example.test0105game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button bstart, bend;
    Chronometer chrono ;
    int count ; //버튼사라지게 할때 사용
    Button[] btnNum = new Button[9];


    int[] btn  = {
            R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = findViewById(R.id.chronometer);
        bstart = findViewById(R.id.btnStart);
        bend = findViewById(R.id.btnEnd);

        for(int i=0; i<btnNum.length; i++){
            btnNum[i] = findViewById(btn[i]); //규연님코드참고
            btnNum[i].setEnabled(false); //9개버튼 하나하나 기술안하고 이런식으로
        }

        //게임시작버튼
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                count = 0 ; //반드시 초기화 필요
                //난수발생,중복체크 Math.random()함수
                int[] rd = new int[9]; //난수기억하는 배열
                for(int i=0; i<9; i++){
                    rd[i] = (int)(Math.random()*9)+1;
                    for(int j=0; j<i; j++){
                        if(rd[i]==rd[j]){ --i;break;}
                    }//j end
                }//i end

                // 시작 버튼을 누르면
                for(int i=0; i<btnNum.length; i++){
                    btnNum[i].setEnabled(true); // 버튼을 활성화하고
                    btnNum[i].setVisibility(vw.VISIBLE); // 버튼을 보이게 한다
                    btnNum[i].setText(String.valueOf(rd[i])); // 랜덤으로 초기화된 배열의 내용을 버튼에 삽입한다
                }

                for(int i=0; i<9; i++){
                    btnNum[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            for(int j=0; j<9; j++) { // 버튼을 누를 때마다 0부터 9까지 반복
                                int sel = view.getId();
                                if(sel == btn[j]){ // 해당하는 버튼을 찾는다.
                                    String sNUM = btnNum[j].getText().toString(); // 버튼에 나와있는 번호를 불러온다
                                    int iNUM = Integer.parseInt(sNUM); // 불러온 번호를 형변환한다
                                    if(iNUM == (count+1)) { // 버튼의 번호가 현재 순서와 같으면
                                        btnNum[j].setVisibility(view.INVISIBLE); // 버튼을 보이지 않게 하고
                                        count++; // 현재 순서를 +1한다.
                                    }
                                }
                            }
                        }
                    });
                }//for end

                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                //크로노미터 TickListener
                chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        //제한시간을 20분으로 하겠습니다
                        String sCurrentTime = chronometer.getText().toString();
                        if(sCurrentTime.equals("경과시간:00:10")){ // 경과시간이 10초를 넘으면
                            chrono.stop(); // 시간을 그만 세고
                            for(int k=0; k<9; k++){btnNum[k].setEnabled(false);} // 버튼을 모두 비활성화한다
                        }
                    }
                });//크로노미터 end
                for(int k=0; k<9; k++){btnNum[k].setEnabled(true);}
            }//on Click
        });//bstart end

        //게임종료버튼
        bend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                for(int i=0; i<btnNum.length; i++){
                    btnNum[i].setVisibility(vw.INVISIBLE);
                }
            }
        });//bend

    }//onCreate end
}//Game class END