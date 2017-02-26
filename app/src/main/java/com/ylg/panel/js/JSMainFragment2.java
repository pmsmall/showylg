package com.ylg.panel.js;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.panel.R;

/**
 * Created by 涛江 on 2016/11/25.
 */

public class JSMainFragment2 extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.js_fragment_main2, container, false);
        // 此处添加背景上的图标
//        rootView.findViewById(R.id.po_yellow).setOnClickListener(this);
        // time:2016-11-26 15:47:50 add by taojiang content:add website button
//        rootView.findViewById(R.id.po_website).setOnClickListener(this);
//        rootView.setOnTouchListener(this);
//        rootView.findViewById(R.id.fb_js_back).setOnClickListener(this);
        return rootView;
    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.po_yellow:
//                // 进入之前做的App页面
//                Intent po_yellow = new Intent(this.getActivity(),JSMainActivity.class);
//                startActivity(po_yellow);
//                break;
//            case R.id.po_website:
//                // 进入三个WebView
//                Intent po_website = new Intent(this.getActivity(),JSShowActivity.class);
//                startActivity(po_website);
//                break;
//            case R.id.fb_js_back:
//                getActivity().finish();
//                break;
//        }
//    }
//
//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        Snackbar.make(view, "小提示:1.点击上方红色区域使用查询服务.2.点击右下角网站,查看技术部网站.3.点击右下方浮动图标,返回上层页面.", Snackbar.LENGTH_SHORT)
//                .setAction("Action", null).show();
//        Log.d("x=",""+motionEvent.getX());
//        Log.d("y=",""+motionEvent.getY());
//        return false;
//    }
}

