package com.ylg.panel.js;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ylg.panel.R;
import com.ylg.panel.js.views.WrapContentWidthCardText;

/**
 * Created by lenovo on 2017/3/21.
 */

public class JSShowTextActivity extends AppCompatActivity implements View.OnClickListener{

    private WrapContentWidthCardText mCardText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.js_activity_showtext);
        // 设置Activity大小
        WindowManager manager = getWindowManager();
        Display d = manager.getDefaultDisplay();

        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.height = (int) (d.getHeight() * 0.8);
//        int width = (int)(lp.height * (originWidth / originHeight));
//        lp.width = (int) (width);
        // 修改 2017年2月19日15:13:57 将原屏幕高度的0.8倍改为全屏
        lp.height = (int) (d.getHeight());
        lp.width = (int) (d.getWidth());
        getWindow().setAttributes(lp);
        getWindow().setGravity(Gravity.CENTER_VERTICAL);
        mCardText = (WrapContentWidthCardText) findViewById(R.id.iv_alert_show);
        mCardText.setBackGroundResource(R.drawable.ylgall2);
        mCardText.setContent(R.string.ylg);
        // 设置fb按钮的监听
        ((FloatingActionButton) findViewById(R.id.fb_back)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fb_back:
                this.finish();
                break;
        }
    }
}
