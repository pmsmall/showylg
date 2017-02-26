package com.ylg.panel.view;

/**
 * Created by 涛江 on 2016/11/25.
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0, width = 0;
        int h = 0, w = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            h = child.getMeasuredHeight();
            w = child.getMeasuredWidth();
            if (h > height)
                height = h;
            if (w > width)
                width = w;
        }
        if (width > 0) {
            int screenWidth = this.getResources().getDisplayMetrics().widthPixels;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (height * screenWidth / width), MeasureSpec.EXACTLY);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(screenWidth, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

