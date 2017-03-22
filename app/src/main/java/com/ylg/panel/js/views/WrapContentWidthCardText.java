package com.ylg.panel.js.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ylg.panel.R;

/**
 * Created by lenovo on 2017/3/21.
 */

public class WrapContentWidthCardText extends RelativeLayout{
    int widthMeasureSpec; int heightMeasureSpec;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 显示文本控件
     */
    private TextView mTextView;
    /**
     * 容纳TextView
     */
    private ScrollView mScrollView;
    /**
     * root 布局
     */
    private RelativeLayout mRoot;

    private ImageView mImageView;
    /**
     * 手机密度
     */
    private float mScale;
    /**
     * 背景图片Id
     */
    private int srcId;

    /**
     * 显示的文字内容
     */
    private String mContent;
    /**
     *
     * @param context
     */
    public WrapContentWidthCardText(Context context) {
        super(context);
        init(context);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public WrapContentWidthCardText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     *
     * @param context
     * @param attrs
     */
    public WrapContentWidthCardText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     *
     * @param context
     */
    private void init(Context context){
        mContext = context;
        mScale = context.getResources().getDisplayMetrics().density;
        LayoutInflater.from(mContext).inflate(R.layout.view_cardtext, this);
        mRoot = (RelativeLayout) findViewById(R.id.root);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mTextView = (TextView) findViewById(R.id.tv_content);
        mImageView = (ImageView) findViewById(R.id.iv_logo);
    }

    /**
     * 设置背景
     * @param imageId
     */
    public void setBackGroundResource(Integer imageId){
        mRoot.setBackgroundResource(imageId);
//        params.leftMargin = leftmargin;
//        params.topMargin = topmargin;
        int imageWidth = (int) (getResources().getDisplayMetrics().heightPixels * 0.8 * 0.2);

        int leftMargin = (int) (getResources().getDisplayMetrics().heightPixels * 0.8 * 0.05);
        LayoutParams params1 = new LayoutParams(imageWidth, imageWidth);
        params1.leftMargin = leftMargin;
        mImageView.setLayoutParams(params1);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.leftMargin = leftMargin;
        params.rightMargin = leftMargin;
        params.bottomMargin = leftMargin;
        params.topMargin = imageWidth + leftMargin / 2;
        mScrollView.setLayoutParams(params);
    }
    public void setContent(Integer strId){
        int textScaleX;
//        mTextView.setTextScaleX(textScaleX);
        Log.d("TAG",""+mScale);
        if(mScale < 2){
            textScaleX = (int) (2 / mScale * 16 + 0.5f);
            mTextView.setTextSize(textScaleX);
        }
        mTextView.setText(strId);
        mTextView.setTextColor(getResources().getColor(R.color.black));
    }
    /**
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0, width = 0;
        height= getMeasuredHeight();
        width = getMeasuredWidth();
        if (height > 0) {
            int screenHeight = (int) (this.getResources().getDisplayMetrics().heightPixels*0.8);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(screenHeight , MeasureSpec.EXACTLY);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)(width * screenHeight/ height), MeasureSpec.EXACTLY);
            this.widthMeasureSpec = widthMeasureSpec;
            this.heightMeasureSpec = heightMeasureSpec;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
