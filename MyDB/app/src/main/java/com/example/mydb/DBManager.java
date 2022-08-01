package com.example.mydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    // Context ct;

    public DBManager(Context context) { // 데이터베이스 이름 myDB를 명명
        // this.ct = context;
        // super(context, "myDB", null, 1);

        super(context, "myDB", null, 1);
        // this.ct = ct;
    } // end

    @Override
    public void onCreate(SQLiteDatabase db) { // table 테이블 생성
        db.execSQL( "create table guest(name text, gender text, sms text);" );
        System.out.println("guest 테이블 생성 ok");
    } // end

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    } // end
} // class END
