package com.ylg.panel.yy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ylg.panel.R;

public class BbsActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);

        webView = (WebView)findViewById(R.id.bbs);

        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:./android_asset/bbs/bbs.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
//                MyWebView myWebView = (MyWebView) view;
//                System.out.println("123333++2");
//                myWebView.loadUrl(url);
//                myWebView.loadUrl(url);
                System.out.println("123333+"+url);
//                myWebView.addClickNumber();
                return false;
            }
        });
    }
}
