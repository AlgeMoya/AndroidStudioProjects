package com.example.day0112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    VideoView vv;
    Button btn1, btn2;
    String VIDEO_URL;
    String path, path2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            vv = findViewById(R.id.videoview);
            btn1 = findViewById(R.id.btnstart);
            btn2 = findViewById(R.id.btnpause);

            VIDEO_URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
            // vv.setVideoURI(Uri.parse(VIDEO_URL)); // 비디오 URI 설정 // 성공..

            path = this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(); //  + "/scuba.mp4";
            path2 = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsoluteFile() + "/scuba.mp4";
            // vv.setVideoPath(path2); // vv.setVideoURI 대신... // 에뮬에서는 작동 안됨 폰에서는 정상

            // res/raw/scuba.mp4 파일
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/scuba");
            vv.setVideoURI(uri);

            System.out.println("path2 경로확인 : " + path2);
            System.out.println("경로: " + path);
            Log.d("youngrim", "경로테스트" + path);
        } catch (Exception ex) {
            System.out.println("01-11-화요일 에러발생" + ex.toString());
        }

        ///////////////////////////////////////////////////////////////////////////////
        // Open a specific media item using ParcelFileDescriptor.
        // ContentResolver resolver = getApplicationContext().getContentResolver();

        // "rw" for read-and-write;
        // "rwt" for truncating or overwriting existing file contents.
        // String readOnlyMode = "r";
        // try (ParcelFileDescriptor pfd =
        //             resolver.openFileDescriptor(Uri.parse(path), "r")) {
            // Perform operations on "pfd".
        // } catch (IOException ex) {
        //    System.out.println("01-11-화요일 점심시간 에러발생" + ex.toString());
        // }
        ///////////////////////////////////////////////////////////////////////////////

        btn1.setOnClickListener(new View.OnClickListener() { // 비디오 시작
            @Override
            public void onClick(View view) {
                try {
                    vv.seekTo(0);
                    vv.start(); // 실제 재생 시작
                } catch (Exception ex) {    }
            }
        }); // btn1 end

        btn2.setOnClickListener(new View.OnClickListener() { // 비디오 정지
            @Override
            public void onClick(View view) {
                try {
                    vv.pause();
                    vv = null;
                } catch (Exception ex) {    }
            }
        }); // btn2 end

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

            }
        }); // end

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

            }
        }); // end
    } // end
} // class END