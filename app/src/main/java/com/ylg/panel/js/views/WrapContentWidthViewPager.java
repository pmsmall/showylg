package com.ylg.panel.js.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lenovo on 2017/2/19.
 */

public class WrapContentWidthViewPager extends ViewPager{
    private Context mContext;
    public WrapContentWidthViewPager(Context context) {
        super(context);
        mContext = context;
    }

    public WrapContentWidthViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0, width = 0;
        int h = 0, w = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            h = child.getMeasuredHeight();
            w = child.getMeasuredWidth();
            Log.d("width&height=",""+w+"&"+h +"***"+i);
            if (h > height)
                height = h;
            if (w > width)
                width = w;
        }
        if (height > 0) {
            int screenHeight = (int) (this.getResources().getDisplayMetrics().heightPixels*0.8);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(screenHeight , MeasureSpec.EXACTLY);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)(width * screenHeight/ height), MeasureSpec.EXACTLY);
            Log.d("after *** width&height=",""+widthMeasureSpec+"&"+heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
