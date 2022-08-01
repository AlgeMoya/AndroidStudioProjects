package com.example.test0111;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Two extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent it = this.getIntent();
        int[ ] count= it.getIntArrayExtra("count");
        String[] imgMsg = it.getStringArrayExtra("imgMsg");

        TextView tv[]=new TextView[imgMsg.length];
        RatingBar rb[]=new RatingBar[imgMsg.length];

        int tvID[ ]={R.id.tv1, R.id.tv2, R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9 };
        int rbID[ ]={R.id.rb1, R.id.rb2, R.id.rb3,R.id.rb4,R.id.rb5,R.id.rb6,R.id.rb7,R.id.rb8,R.id.rb9 };

        for(int i=0; i<9; i++){
          tv[i] = findViewById(tvID[i]);
          rb[i] = findViewById(rbID[i]);

          tv[i].setText(imgMsg[i]);
          rb[i].setRating((float)count[i]);
        }

        //버튼제어하기
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }//end
}//Two class END
