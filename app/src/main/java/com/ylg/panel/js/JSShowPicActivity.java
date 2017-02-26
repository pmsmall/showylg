package com.ylg.panel.js;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ylg.panel.R;
import com.ylg.panel.js.views.WrapContentWidthImageView;

/**
 * Created by lenovo on 2016/11/28.
 */

public class JSShowPicActivity extends AppCompatActivity implements View.OnClickListener{
    private double originWidth = 2458;
    private double originHeight = 1382;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.js_activity_showpic);
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
        // 设置图片
        int picId = getIntent().getFlags();
        Log.d("picId",""+picId);
        ((WrapContentWidthImageView) findViewById(R.id.iv_alert_show)).setImageResource(picId);
//        lp.width = (int) (d.getWidth() * 0.6);
//        int height = (int)(((lp.width * (originHeight / originWidth) * 2) > (d.getHeight() * 0.9))?d.getHeight() * 0.9:lp.width * (originHeight / originWidth) * 2);
//        lp.height = (int) (height);
//        getWindow().setAttributes(lp);
//        getWindow().setGravity(Gravity.CENTER_VERTICAL);
        // 设置fb按钮的监听
        ((FloatingActionButton) findViewById(R.id.fb_back)).setOnClickListener(this);
    }

    /**
     * 2017年2月19日15:25:46 添加二级页面的返回fb按钮，并将弹出页面设置为全屏
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fb_back:
                this.finish();
                break;
        }
    }
}
