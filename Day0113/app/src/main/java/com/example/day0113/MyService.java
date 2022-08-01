package com.example.day0113;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mediaPlayer; // onCreate메소드에서 개체 생성

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
        // return null;
    } // onBind end

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.pinksweat);
        mediaPlayer.setLooping(true);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("미디어플레이 시작합니다");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("미디어플레이 종료합니다");
        mediaPlayer.stop();
        super.onDestroy();
    }
} // MyService end