package com.example.day0114;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    ProgressBar pb;
    EditText et;
    // String url = "https://recipes4dev.tistory.com/154";
    // String url = "https://m.daum.net/";
    String url = "https://m.naver.com/";
    // https://m.daum.net/   https://m.naver.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressbar);
        pb.setVisibility(View.GONE); // pb 로딩바 숨기기
        // pb.setVisibility(View.VISIBLE); // pb 로딩바 보여주기

        et = findViewById(R.id.editText);
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE) {
                    wv.loadUrl("https://" + et.getText().toString() + ""); // 수정 가능한 부분은 toString이 필요
                }
                return false;
            }
        }); // et end

        wv = findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClientClass());
    } // end

    // 내부 클래스
    public class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        } // end

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pb.setVisibility(View.VISIBLE); // pb 로딩바 보여주기
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pb.setVisibility(View.GONE); // pb 로딩바 숨기기
            super.onPageFinished(view, url);
        }
    } // class END
} // class END