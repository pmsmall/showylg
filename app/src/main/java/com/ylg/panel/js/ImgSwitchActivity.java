package com.ylg.panel.js;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ylg.panel.R;
import com.ylg.panel.js.adapters.LogoPageAdapter;
import com.ylg.panel.js.circle.ImageCycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/19.
 */

public class ImgSwitchActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageCycleView xc_images;
    private LogoPageAdapter mAdapter;

    private List<View> imgList;
    private List<Integer> imgId;
//    private RadioGroup gallery_group;
    private static final int FW = 0;
    private static final int YL = 1;
    private static final int NJ = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.js_activity_switch_image);

        // 设置Activity大小
        WindowManager manager = getWindowManager();
        Display d = manager.getDefaultDisplay();

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.height = (int) (d.getHeight());
        lp.width = (int) (d.getWidth());
        getWindow().setAttributes(lp);
        getWindow().setGravity(Gravity.CENTER_VERTICAL);

        xc_images = (ImageCycleView) findViewById(R.id.xc_images);
        xc_images.setCycle_T(ImageCycleView.CYCLE_T.CYCLE_VIEW_NORMAL);
        ArrayList<String> imageDescList=new ArrayList<>();
        ArrayList<Integer> idList=new ArrayList<>();
        switch (getIntent().getFlags()){
            case FW:
                idList.add(R.drawable.fw1);
                imageDescList.add("");
                break;
            case YL:
                idList.add(R.drawable.yl1);
                idList.add(R.drawable.yl2);
                idList.add(R.drawable.yl3);
                idList.add(R.drawable.yl4);
                idList.add(R.drawable.yl5);
                imageDescList.add("");
                imageDescList.add("");
                imageDescList.add("");
                imageDescList.add("");
                imageDescList.add("");
                break;
            case NJ:
                idList.add(R.drawable.nj1);
                imageDescList.add("");
                break;
        }
        initCarsuelView(imageDescList, idList);
//        imgList = new ArrayList<View>();
//        imgId = new ArrayList<>();
//        imgId.add(R.drawable.xuanchuan);
//        imgId.add(R.drawable.bbs);
//        for(int i = 0;i < imgId.size();i++){
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(imgId.get(i));
//            imgList.add(imageView);
//        }
//        mAdapter = new LogoPageAdapter(imgList,this);
//        xc_images.setAdapter(mAdapter);
//        xc_images.setOnPageChangeListener(this);
//        // 设置小按钮
//        RadioButton[] gallery_points = new RadioButton[imgList.size()];
//        for (int i = 0;i < gallery_points.length;i++){
//
//        }


        // 设置fb按钮的监听
        ((FloatingActionButton) findViewById(R.id.fb_back)).setOnClickListener(this);

    }

    // 点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fb_back:
                this.finish();
                break;
        }
    }


    /**初始化轮播图*/
    public void initCarsuelView(ArrayList<String> imageDescList,ArrayList<Integer>urlList) {
        RelativeLayout.LayoutParams cParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, getScreenHeight(this) * 1);
        xc_images.setLayoutParams(cParams);
        ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void onImageClick(int position, View imageView) {
                /**实现点击事件*/

            }
            @Override
            public void displayImage(int imageId, ImageView imageView) {
                /**在此方法中，显示图片，可以用自己的图片加载库，也可以用本demo中的（Imageloader）*/
                imageView.setImageResource(imageId);
            }
        };
        /**设置数据*/
        xc_images.setImageResources(imageDescList,urlList, mAdCycleViewListener);
        // 是否隐藏底部
        xc_images.hideBottom(false);
        xc_images.startImageCycle();
    }

    /**
     * 得到屏幕的高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        if (null == context) {
            return 0;
        }
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
