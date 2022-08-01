package com.cookandroid.project10_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class AActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onClick (View v) {
        // intent.putExtra("NAME", "Superdroid");
        // startActivity(intent);
    }
}
