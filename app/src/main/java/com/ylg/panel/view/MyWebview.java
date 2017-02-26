package com.ylg.panel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import java.util.Map;

/**
 * Created by 天楠 on 2016/11/25.
 */

public class MyWebview extends WebView {

    public MyWebview(Context context) {
        super(context);
        init();
    }

    public MyWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    private void init() {
        loadUrl("http://bbs.csu.edu.cn/");
    }

    @Override
    public void loadUrl(String url) {
        if (url.equals("http://bbs.csu.edu.cn/new.html"))
            url = "http://bbs.csu.edu.cn/bbs/forum.php";
        super.loadUrl(url);
    }

    @Override
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        if (url.equals("http://bbs.csu.edu.cn/new.html"))
            url = "http://bbs.csu.edu.cn/bbs/forum.php";
        super.loadUrl(url, additionalHttpHeaders);
    }
}
