package com.ylg.panel.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ylg.panel.R;

/**
 * Created by lenovo on 2016/11/26.
 */

public class JSShowActivity extends AppCompatActivity  implements View.OnKeyListener{
    private static final String URL_1 = "http://fdy.csu.edu.cn/Default.aspx";
    private static final String URL_2 = "http://fdy.csu.edu.cn/job";
    private static final String URL_3 = "http://fdy.csu.edu.cn/exam/";
    public WebView wv1;
    public WebView wv2;
    public WebView wv3;
    boolean isActivityBack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_activity_show_webview);
        // 此处添加加载WebView的网址
        wv1 = ((WebView) findViewById(R.id.webview_1));
        wv2 = ((WebView) findViewById(R.id.webview_2));
        wv3 = ((WebView) findViewById(R.id.webview_3));

        wv1.getSettings().setSupportZoom(true);
        wv2.getSettings().setSupportZoom(true);
        wv3.getSettings().setSupportZoom(true);
        wv1.getSettings().setBuiltInZoomControls(true);
        wv2.getSettings().setBuiltInZoomControls(true);
        wv3.getSettings().setBuiltInZoomControls(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv2.getSettings().setJavaScriptEnabled(true);
        wv3.getSettings().setJavaScriptEnabled(true);
//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int mDensity = metrics.densityDpi;
//        Log.d("maomao", "densityDpi = " + mDensity);
//        if (mDensity == 240) {
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        } else if (mDensity == 160) {
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//        } else if(mDensity == 120) {
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
//        }else if(mDensity == DisplayMetrics.DENSITY_XHIGH){
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        }else if (mDensity == DisplayMetrics.DENSITY_TV){
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        }else{
//            wv1.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//        }
        wv1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv1.getSettings().setLoadWithOverviewMode(true);
        wv1.getSettings().setUseWideViewPort(true);
        wv2.getSettings().setUseWideViewPort(true);
        wv2.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv2.getSettings().setLoadWithOverviewMode(true);
        wv3.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv3.getSettings().setLoadWithOverviewMode(true);
        wv3.getSettings().setUseWideViewPort(true);
        wv1.setWebViewClient(new WebViewClient(){
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wv2.setWebViewClient(new WebViewClient(){
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wv3.setWebViewClient(new WebViewClient(){
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        wv1.setOnKeyListener(this);
        wv2.setOnKeyListener(this);
        wv3.setOnKeyListener(this);
        wv1.loadUrl(URL_1);
        wv2.loadUrl(URL_2);
        wv3.loadUrl(URL_3);
    }

    @Override
    public void onBackPressed() {

    }

    private void exit(){
        this.finish();
    }
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (keyEvent.getAction()){
            case KeyEvent.ACTION_DOWN:
                if (i == KeyEvent.KEYCODE_BACK) {
                    ((WebView) view).goBack();
                    if (!((WebView) view).canGoBack()){
                        exit();
                    }
                }
                break;
        }
        return false;
    }
}
