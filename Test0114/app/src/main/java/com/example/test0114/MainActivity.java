package com.example.test0114;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // this.setContentView(); // View 타입이면 xml 문서 연결 안 해도 됨
        // setContentView(new MyPicture(this));
        MyPicture mp = new MyPicture(this);
        setContentView(mp);
    } // onCreate end
} // MainActivity class END

class MyPicture extends View {
    int x = 500, y = 500;
    Paint paint = new Paint();
    Path path = new Path();
    Context context;
    // 힌트1 생성자
    // 힌트2 onTouchEvent(MotionEvent) { }
    // 힌트3 onDraw(Canvas)

    public MyPicture(Context ct) {
        super(ct);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE); // 필수항목 기술
        paint.setStrokeWidth(20f); // 선의 굵기
        paint.setStrokeCap(Paint.Cap.ROUND);
    } // end

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        int ac = event.getAction();

        if (ac == MotionEvent.ACTION_DOWN) {
            path.moveTo(x, y);
        } else if (ac == MotionEvent.ACTION_MOVE) {
            path.lineTo(x, y);
        }

        this.invalidate();
        return true;
        // return super.onTouchEvent(event);
    } // end

    public void onDraw(Canvas cv) {
        cv.drawPath(path, paint);
    }
} // MyPicture class END