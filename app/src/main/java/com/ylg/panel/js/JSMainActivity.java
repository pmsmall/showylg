package com.ylg.panel.js;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylg.panel.R;
import com.ylg.panel.js.adapters.LogoPageAdapter;
import com.ylg.panel.js.tabs.CetTab;
import com.ylg.panel.js.tabs.ComTab;
import com.ylg.panel.js.tabs.PercentTab;
import com.ylg.panel.js.tabs.PersonTab;
import com.ylg.panel.js.tabs.TeacherTab;
import com.ylg.panel.js.views.WrapContentHeightViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 涛江 on 2016/11/25.
 */

public class JSMainActivity extends AppCompatActivity implements View.OnClickListener {
//,NavigationView.OnNavigationItemSelectedListener{

    private double originWidth = 1080;
    private double originHeight = 384;
    // 图片数组
    private int imageArray[] = {R.drawable.js_ylg, R.drawable.js_app};
    private ImageView imageView;
    private ViewPager vp_searchPages; // 查询时的ViewPager
    //2016.11.10重写自适应的组件
    private WrapContentHeightViewPager vp_images;  // 上方显示图片的ViewPager
    private FragmentPagerAdapter mAdapter;
    private LogoPageAdapter mLogoAdapter;
    //private LinearLayout tb;
    private LinearLayout tb1;
    private LinearLayout tb2;
    private LinearLayout tb3;
    private LinearLayout tb4;
    //2017-02-20 02:48:34 添加辅导员
    private LinearLayout tb5;
    List<Fragment> lists = new ArrayList<>();
    ArrayList<View> viewlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.js_activity_main);
        // 设置Activity大小
        WindowManager manager = getWindowManager();
        Display d = manager.getDefaultDisplay();

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (d.getWidth() * 0.7);
        int height = (int)(((lp.width * (originHeight / originWidth) * 2) > (d.getHeight() * 0.95))?d.getHeight() * 0.95:lp.width * (originHeight / originWidth) * 2);
        lp.height = (int) (height);
        getWindow().setAttributes(lp);
        getWindow().setGravity(Gravity.CENTER_VERTICAL);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        if(getSupportActionBar() != null){
//            Log.d("null？","!null");
//            getSupportActionBar().hide();
//        }
//        Log.d("null？","null");
        initView();

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        //      NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //       navigationView.setNavigationItemSelectedListener(this);
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork()
//                .penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
//                .penaltyLog().penaltyDeath().build());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return lists.get(position);
            }

            @Override
            public int getCount() {
                return lists.size();
            }
        };
        vp_searchPages.setAdapter(mAdapter);
        vp_searchPages.setCurrentItem(0);
        ((ImageButton) tb1.findViewById(R.id.btn_tab_cet))
                .setImageResource(R.drawable.js_cet_press);
        ((TextView) tb1.findViewById(R.id.tv_tab_cet))
                .setTextColor(Color.rgb(93, 179, 210));
        vp_searchPages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int currentIndex;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                resetButton();
//                switch (position) {
//                    case 0:
//                        ((ImageButton) tb1.findViewById(R.id.btn_tab_bottom_weixin))
//                                .setImageResource(R.drawable.cet_press);
//                        break;
//                    case 1:
//                        ((ImageButton) tb2.findViewById(R.id.btn_tab_bottom_friend))
//                                .setImageResource(R.drawable.computer_press);
//                        break;
//                    case 2:
//                        ((ImageButton) tb3.findViewById(R.id.btn_tab_bottom_contact))
//                                .setImageResource(R.drawable.boygirl_press);
//                        break;
//                    case 3:
//                        ((ImageButton) tb4.findViewById(R.id.btn_tab_bottom_setting))
//                                .setImageResource(R.drawable.god2_press);
//                        break;
//                    default:
//                        break;
//                }
//                vp_searchPages.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == 2) {
                    resetButton();
                    switch (vp_searchPages.getCurrentItem()) {
                        case 0:
                            ((ImageButton) tb1.findViewById(R.id.btn_tab_cet))
                                    .setImageResource(R.drawable.js_cet_press);
                            ((TextView) tb1.findViewById(R.id.tv_tab_cet))
                                    .setTextColor(Color.rgb(93, 179, 210));
                            break;
                        case 1:
                            ((ImageButton) tb2.findViewById(R.id.btn_tab_computer))
                                    .setImageResource(R.drawable.js_computer_press);
                            ((TextView) tb2.findViewById(R.id.tv_tab_computer))
                                    .setTextColor(Color.rgb(93, 179, 210));
                            break;
                        case 2:
                            ((ImageButton) tb3.findViewById(R.id.btn_tab_person))
                                    .setImageResource(R.drawable.js_god2_press);
                            ((TextView) tb3.findViewById(R.id.tv_tab_person))
                                    .setTextColor(Color.rgb(93, 179, 210));
                            break;
                        case 3:
                            ((ImageButton) tb4.findViewById(R.id.btn_tab_percent))
                                    .setImageResource(R.drawable.js_boygirl_press);
                            ((TextView) tb4.findViewById(R.id.tv_percent))
                                    .setTextColor(Color.rgb(93, 179, 210));
                            break;
                        case 4:
                            ((ImageButton) tb5.findViewById(R.id.btn_tab_teacher))
                                    .setImageResource(R.drawable.js_teacher_press);
                            ((TextView) tb5.findViewById(R.id.tv_tab_teacher))
                                    .setTextColor(Color.rgb(93, 179, 210));
                            break;
                        default:
                            break;
                    }
//                    vp_searchPages.setCurrentItem(position);
                }
            }
        });
    }


    private void resetButton() {
        ((ImageButton) tb1.findViewById(R.id.btn_tab_cet))
                .setImageResource(R.drawable.js_cet_normal);
        ((TextView) tb1.findViewById(R.id.tv_tab_cet))
                .setTextColor(Color.rgb(126, 161, 177));
        ((ImageButton) tb2.findViewById(R.id.btn_tab_computer))
                .setImageResource(R.drawable.js_computer_normal);
        ((TextView) tb2.findViewById(R.id.tv_tab_computer))
                .setTextColor(Color.rgb(126, 161, 177));
        ((ImageButton) tb3.findViewById(R.id.btn_tab_person))
                .setImageResource(R.drawable.js_god2_normal);
        ((TextView) tb3.findViewById(R.id.tv_tab_person))
                .setTextColor(Color.rgb(126, 161, 177));
        ((ImageButton) tb4.findViewById(R.id.btn_tab_percent))
                .setImageResource(R.drawable.js_boygirl_normal);
        ((TextView) tb4.findViewById(R.id.tv_percent))
                .setTextColor(Color.rgb(126, 161, 177));
        ((ImageButton) tb5.findViewById(R.id.btn_tab_teacher))
                .setImageResource(R.drawable.js_teacher_normal);
        ((TextView) tb5.findViewById(R.id.tv_tab_teacher))
                .setTextColor(Color.rgb(126, 161, 177));
    }

    private void initView() {
//        //tb=(LinearLayout) findViewById(R.id.line);
        tb1 = (LinearLayout) findViewById(R.id.id_tab_cet);
        tb2 = (LinearLayout) findViewById(R.id.id_tab_computer);
        tb3 = (LinearLayout) findViewById(R.id.id_tab_person);
        tb4 = (LinearLayout) findViewById(R.id.id_tab_percent);
        tb5 = (LinearLayout) findViewById(R.id.id_tab_teacher);
//        Log.d("tab1",""+(tb1 == null));
        tb1.setOnClickListener(this);
        tb2.setOnClickListener(this);
        tb3.setOnClickListener(this);
        tb4.setOnClickListener(this);
        tb5.setOnClickListener(this);
        vp_searchPages = (ViewPager) findViewById(R.id.vp_searchPages);
        CetTab tab1 = new CetTab();
        ComTab tab2 = new ComTab();
        PersonTab tab3 = new PersonTab();
        PercentTab tab4 = new PercentTab();
        TeacherTab tab5 = new TeacherTab();
        lists.add(tab1);
        lists.add(tab2);
        lists.add(tab3);
        lists.add(tab4);
        lists.add(tab5);
        // 2016-11-05 19:14:15
        // 初始化上方图片显示
        vp_images = (WrapContentHeightViewPager) findViewById(R.id.vp_images);
        viewlist = new ArrayList<View>();
        for (int i = 0; i < imageArray.length; i++) {
            imageView = new ImageView(this);
            imageView.setBackgroundResource(imageArray[i]);
            viewlist.add(imageView);
        }
        mLogoAdapter = new LogoPageAdapter(viewlist, this);
        vp_images.setAdapter(mLogoAdapter);
        vp_images.setCurrentItem(0);
    }

    @Override
    public void onClick(View v) {
        resetButton();
        Intent activityIntent;
        switch (v.getId()) {
//                    case R.id.btn_tab_bottom_weixin:
            case R.id.id_tab_cet:
                vp_searchPages.setCurrentItem(0);
                ((ImageButton) tb1.findViewById(R.id.btn_tab_cet))
                        .setImageResource(R.drawable.js_cet_press);
                ((TextView) tb1.findViewById(R.id.tv_tab_cet))
                        .setTextColor(Color.rgb(93, 179, 210));
                //致命错误，忘记加break!!!
//                activityIntent = new Intent(MainActivity.this, CetActivity.class);
//                startActivity(activityIntent);
                break;
            case R.id.id_tab_computer:
                vp_searchPages.setCurrentItem(1);
                ((ImageButton) tb2.findViewById(R.id.btn_tab_computer))
                        .setImageResource(R.drawable.js_computer_press);
                ((TextView) tb2.findViewById(R.id.tv_tab_computer))
                        .setTextColor(Color.rgb(93, 179, 210));
                break;
            case R.id.id_tab_person:
                vp_searchPages.setCurrentItem(2);
                ((ImageButton) tb3.findViewById(R.id.btn_tab_person))
                        .setImageResource(R.drawable.js_god2_press);
                ((TextView) tb3.findViewById(R.id.tv_tab_person))
                        .setTextColor(Color.rgb(93, 179, 210));
                break;
            case R.id.id_tab_percent:
                vp_searchPages.setCurrentItem(3);
                ((ImageButton) tb4.findViewById(R.id.btn_tab_percent))
                        .setImageResource(R.drawable.js_boygirl_press);
                ((TextView) tb4.findViewById(R.id.tv_percent))
                        .setTextColor(Color.rgb(93, 179, 210));
                break;
            case R.id.id_tab_teacher:
                vp_searchPages.setCurrentItem(4);
                ((ImageButton) tb5.findViewById(R.id.btn_tab_teacher))
                        .setImageResource(R.drawable.js_teacher_press);
                ((TextView) tb5.findViewById(R.id.tv_tab_teacher))
                        .setTextColor(Color.rgb(93, 179, 210));
                break;
        }
    }

}

