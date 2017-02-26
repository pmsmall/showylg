package com.ylg.panel.js;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ylg.panel.R;
import com.ylg.panel.js.tools.AdaptParamer;
import com.ylg.panel.thread.IconManager;

/**
 * Created by 涛江 on 2016/11/25.
 */

public class JSMainActivity2 extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private AdaptParamer adaptParamer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.js_activity_main2);
//        ((Button) findViewById(R.id.po_yellow)).setOnClickListener(this);
//        ((Button) findViewById(R.id.po_website)).setOnClickListener(this);
        ((FloatingActionButton) findViewById(R.id.fb_js_back)).setOnClickListener(this);
        findViewById(R.id.js_fragment).setOnTouchListener(this);
//        getSupportActionBar().hide();
//        DisplayMetrics dm = new DisplayMetrics();//捕获屏幕信息
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
        adaptParamer = new AdaptParamer(IconManager.iconManager.screen_width, IconManager.iconManager.screen_height);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.po_yellow:
//                // 进入之前做的App页面
//                Intent po_yellow = new Intent(this,JSMainActivity.class);
//                startActivity(po_yellow);
//                break;
//            case R.id.po_website:
//                // 进入三个WebView
//                Intent po_website = new Intent(this,JSShowActivity.class);
//                startActivity(po_website);
//                break;
            case R.id.fb_js_back:
                this.finish();
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (adaptParamer.inGod(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inGirl(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inAll(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inGrade(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inTeacher(motionEvent.getX(), motionEvent.getY())) {
            Intent po_red = new Intent(this, JSMainActivity.class);
            startActivity(po_red);

        } else if (adaptParamer.inYellow(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inSchool(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inIn(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inCar(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inLaoxiang(motionEvent.getX(), motionEvent.getY())) {

//            Bundle picId = new Bundle();
//            picId.putInt("picId",R.raw.yello);
            Intent po_yellow = new Intent(this,JSShowPicActivity.class);
            Log.d("picId",""+R.drawable.yello);
            po_yellow.setFlags(R.drawable.yello);
            startActivity(po_yellow);
        } else if (adaptParamer.inTalk(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inGame(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inDaohang(motionEvent.getX(), motionEvent.getY()) ||
                adaptParamer.inRepair(motionEvent.getX(), motionEvent.getY())) {
//            Bundle picId = new Bundle();
//            picId.putInt("picId",R.raw.blue);
            Intent po_blue = new Intent(this,JSShowPicActivity.class);
            po_blue.setFlags(R.drawable.blue);
            startActivity(po_blue);
        } else {
            int i = 0;
            for (; i < 6; i++) {
                if (adaptParamer.inWeb(i, motionEvent.getRawX(), motionEvent.getRawY()))
                    break;
            }
            switch (i) {
                case 0:
                    //fudaoyuan
                    Intent po_jingsai = new Intent(this,JSShowPicActivity.class);
                    po_jingsai.setFlags(R.drawable.fudaoyuanjingsai);
                    startActivity(po_jingsai);
                    break;
                case 1:
                    //xinlijiankang
                    Intent po_xili = new Intent(this,JSShowPicActivity.class);
                    po_xili.setFlags(R.drawable.xinlijiankang);
                    startActivity(po_xili);
                    break;
                case 2:
                    //jianxingwang
                    Intent po_jianxing = new Intent(this,JSShowPicActivity.class);
                    po_jianxing.setFlags(R.drawable.jianxingwang);
                    startActivity(po_jianxing);
                    break;
                case 3:
                    //yingping
                    Intent po_yingping = new Intent(this,JSShowPicActivity.class);
                    po_yingping.setFlags(R.drawable.fudaoyuanzhaop);
                    startActivity(po_yingping);
                    break;
                case 4:
                    //yuqing
                    Intent po_yuqing = new Intent(this,JSShowPicActivity.class);
                    po_yuqing.setFlags(R.drawable.yuqing);
                    startActivity(po_yuqing);
                    break;
                case 5:
                    //peixun
                    Intent po_peixun = new Intent(this,JSShowPicActivity.class);
                    po_peixun.setFlags(R.drawable.fudaoyuanjidi);
                    startActivity(po_peixun);
                    break;
                default:
                    Snackbar.make(view, "小提示:1.点击上方红色区域使用查询服务.2.点击右下角网站,查看技术部网站.3.点击右下方浮动图标,返回上层页面.", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
            }

        }
        Log.d("x=", "" + motionEvent.getX());
        Log.d("y=", "" + motionEvent.getY());
        return false;
    }
}

