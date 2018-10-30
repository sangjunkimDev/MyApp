package com.project.sangjun.myapp.view.splash;

import android.content.Intent;
import android.os.Bundle;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;
import com.project.sangjun.myapp.view.main.MainActivity;
import com.project.sangjun.myapp.view.webview.WebViewActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
