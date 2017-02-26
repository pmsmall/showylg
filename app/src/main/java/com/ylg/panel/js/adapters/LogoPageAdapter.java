package com.ylg.panel.js.adapters;

/**
 * Created by 涛江 on 2016/11/25.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LogoPageAdapter extends PagerAdapter {
    private List<View> viewList;
    private Context context;

    public LogoPageAdapter(List<View> viewList,Context context){
        this.viewList = viewList;
        this.context = context;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

}

