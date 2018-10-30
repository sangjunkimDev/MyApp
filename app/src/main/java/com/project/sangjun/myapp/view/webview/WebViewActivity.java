package com.project.sangjun.myapp.view.webview;

import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends BaseActivity {
    @BindView(R.id.wv_main) WebView wv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebSettings webSettings = wv_main.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv_main.loadUrl("https://m.naver.com/");
        wv_main.setWebViewClient(new MyWebViewClient());
        wv_main.setWebChromeClient(new MyWebChromeClient());

    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }
}
