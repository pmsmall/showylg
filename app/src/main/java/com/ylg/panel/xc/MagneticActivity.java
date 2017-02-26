package com.ylg.panel.xc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ylg.panel.R;

public class MagneticActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);

        webView = (WebView)findViewById(R.id.magneticWebView);

        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:./android_asset/magnetic/xcb.html");
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
