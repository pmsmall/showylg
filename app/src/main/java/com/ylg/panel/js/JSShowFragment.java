package com.ylg.panel.js;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.panel.R;

/**
 * Created by lenovo on 2016/11/26.
 */

public class JSShowFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.js_show_webview,container,false);
        return rootView;
    }
}
