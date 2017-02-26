package com.ylg.panel.js.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lenovo on 2016/11/28.
 */

public class WrapContentWidthImageView extends ImageView{

    private Context mContext;
    public WrapContentWidthImageView(Context context) {
        super(context);
        mContext = context;
    }

    public WrapContentWidthImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0, width = 0;
        height= getMeasuredHeight();
        width = getMeasuredWidth();

        if (height > 0) {
            int screenHeight = (int) (this.getResources().getDisplayMetrics().heightPixels*0.8);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(screenHeight , MeasureSpec.EXACTLY);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)(width * screenHeight/ height), MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
