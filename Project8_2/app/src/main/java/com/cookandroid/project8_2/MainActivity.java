package com.cookandroid.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    TextView tvCount;
    int curNum = 0;
    File[] imageFiles;
    String imageFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);
        tvCount = (TextView) findViewById(R.id.tvCount);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageFrame = imageFiles[curNum].toString();
        myPicture.imagePath = imageFrame;
        tvCount.setText((curNum + 1) + "/" + (imageFiles.length - 2));

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다", Toast.LENGTH_SHORT).show();
                } else {
                    curNum--;
                    imageFrame = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                    tvCount.setText((curNum + 1) + "/" + (imageFiles.length - 2));
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length - 3) {
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                } else {
                    curNum++;
                    imageFrame = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                    tvCount.setText((curNum + 1) + "/" + (imageFiles.length - 2));
                }
            }
        });
    }
}