package com.ylg.panel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ylg.panel.js.ImgSwitchActivity;
import com.ylg.panel.js.JSMainActivity2;
import com.ylg.panel.js.JSShowPicActivity;
import com.ylg.panel.thread.HomeThread;
import com.ylg.panel.thread.IconManager;
import com.ylg.panel.thread.RandomThread;
import com.ylg.panel.thread.RefreshThread;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView center;
    private Canvas canvas, layoutCanvas;
    private Paint pen;
    private Bitmap bitmap, centerImage, js, yy, xz, wm, xc, background, defaultCenter, titleBitmap, titleBitmap1;
    private Image image;
    private RelativeLayout relativeLayout;
    private RefreshThread refresh;
    private HomeThread thread;
    private IconManager m = IconManager.iconManager;
    private float bitmapWidth = 1024;
    private float bitmapHeight = 576;
    private int[] imageviewId = {R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8};
    private ImageView[] views;
    private ImageView title, title1;
    private FloatingActionButton fab;
    private boolean startFresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setBackgroundResource(R.drawable.ylg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "云麓谷，即为中南大学网络文化服务中心，隶属于中南大学学工部，以“服务师生，培养人才”为宗旨。", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        center = (ImageView) findViewById(R.id.imageView2);
        title = (ImageView) findViewById(R.id.imageView3);
        title1 = (ImageView) findViewById(R.id.imageView9);
        relativeLayout = (RelativeLayout) findViewById(R.id.content_main);
        init();
    }

    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getInfo() {
        IconManager.iconManager.screen_width = this.getResources().getDisplayMetrics().widthPixels;
        IconManager.iconManager.screen_height = this.getResources().getDisplayMetrics().heightPixels;
    }

    private void show(String result) {
        new AlertDialog.Builder(MainActivity.this).setTitle("").setMessage(result).setPositiveButton("是", null).show();
    }

    private void init() {
        getInfo();

        title.setAlpha(0.9f);
        title1.setAlpha(0.9f);
        //center.setOnTouchListener(new MyTouchListener());

        pen = new Paint();
        canvas = new Canvas();
        Resources resources = this.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.home_center);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(inputStream);
        centerImage = bitmapDrawable.getBitmap();
        centerImage = resizeBitmap2(centerImage, m.screen_width, m.screen_height);

        inputStream = resources.openRawResource(R.raw.chengzhang);
        bitmapDrawable = new BitmapDrawable(inputStream);
        titleBitmap = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.yuren);
        bitmapDrawable = new BitmapDrawable(inputStream);
        titleBitmap1 = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.js);
        bitmapDrawable = new BitmapDrawable(inputStream);
        js = bitmapDrawable.getBitmap();
        RandomThread.width = js.getWidth();

        inputStream = resources.openRawResource(R.raw.xc);
        bitmapDrawable = new BitmapDrawable(inputStream);
        xc = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.xz);
        bitmapDrawable = new BitmapDrawable(inputStream);
        xz = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.wm);
        bitmapDrawable = new BitmapDrawable(inputStream);
        wm = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.yy);
        bitmapDrawable = new BitmapDrawable(inputStream);
        yy = bitmapDrawable.getBitmap();

//        inputStream = resources.openRawResource(R.raw.ylg);
//        bitmapDrawable = new BitmapDrawable(inputStream);
//        Bitmap logo = bitmapDrawable.getBitmap();
//
//        fab.setBackgroundResource(R.drawable.ylg);
//
//        fab.setImageBitmap(logo);

        thread = new HomeThread();
        refresh = new RefreshThread(this);
        thread.start();
        refresh.start();

        center.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                startActivity(intent);
//                String result = " 云麓谷工作室，成立于2013年，前身是2000年成立的中国大学生勤工助学在线，是中南大学网络文化服务中心的重要组成部分，隶属于中南大学学生工作部（处）。奉行“技术中成长，服务中育人”的理念，多年来创作了一批批“富有特色、导向正确、影响深远”的网络文化微产品，服务师生。其中，由我们提供技术支持的辅导员技能大赛系统，在湖南省高校广泛使用，有利于湖南省辅导员素质的提升。另外，云麓谷服务号作为中南大学唯一的信息服务型多功能综合性微信号，兼具娱乐性、实用性、互动性于一体，目前拥有粉丝量15000余人 ，举办的“最美辅导员”活动，信息接收量达693912。查空教室，四六级成绩，计算机成绩，找人等多种快捷的功能广受学生欢迎，最近的一次四六级查询，一天内的查询量就达到77977次。通过交互型微产品，云麓工作室宣传网络德育，加强校园网络文明的构建力量，唱响网络思想文化主旋律。";
//                show(result);
//
//                Intent po_yellow = new Intent(MainActivity.this, JSShowPicActivity.class);
//                po_yellow.setFlags(R.drawable.ylgall);
//                startActivity(po_yellow);
                return false;
            }
        });
        new initThread().start();

        inputStream = resources.openRawResource(R.raw.background);
        bitmapDrawable = new BitmapDrawable(inputStream);
        relativeLayout.setBackground(bitmapDrawable);
        background = bitmapDrawable.getBitmap();

        inputStream = resources.openRawResource(R.raw.home);
        bitmapDrawable = new BitmapDrawable(inputStream);
        defaultCenter = bitmapDrawable.getBitmap();

        // 时间:2016-11-25 14:40:00   这上边有错误 java.lang.IllegalStateException: Immutable bitmap passed to Canvas constructor
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.home_center);
        bitmap = Bitmap.createBitmap(bitmap1.getWidth() / 2, bitmap1.getHeight() / 2, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
//        layoutCanvas = new Canvas(relativeLayout.getDrawingCache());

//        relativeLayoutsynchronized (this) {
//            canvas.drawBitmap(defaultCenter, m.screen_width, m.screen_height, pen);
//            center.setImageBitmap(bitmap);
//        }
//        修改:2016年11月25日14:25:54 by: 涛江  空指针异常，初始化顺序
//
//        thread=new HomeThread();
//        refresh=new RefreshThread(this);
//        thread.start();
//        refresh.start();

    }

    boolean isInited = false;

    class initThread extends Thread {
        public void run() {
            try {
                while (js.getHeight() < 0) Thread.sleep(10);
                m.js_x0 = getPreferenceX(276, js.getWidth());
                m.js_y0 = getPreferenceY(291, js.getHeight());
                while (wm.getHeight() < 0) Thread.sleep(10);
//                m.wm_x0 = getPreferenceX(495.1f, wm.getWidth());
//                m.wm_y0 = getPreferenceY(34, wm.getHeight());
                m.wm_x0 = getPreferenceX(602.4f, wm.getWidth());
                m.wm_y0 = getPreferenceY(363.47f, wm.getHeight());
                while (yy.getHeight() < 0) Thread.sleep(10);
                m.yy_x0 = getPreferenceX(217, yy.getWidth());
                m.yy_y0 = getPreferenceY(89, yy.getHeight());
                while (xc.getHeight() < 0) Thread.sleep(10);
//                m.xc_x0 = getPreferenceX(602.4f, xc.getWidth());
//                m.xc_y0 = getPreferenceY(363.47f, xc.getHeight());
                m.xc_x0 = getPreferenceX(495.1f, xc.getWidth());
                m.xc_y0 = getPreferenceY(34, xc.getHeight());
                while (xz.getHeight() < 0) Thread.sleep(10);
                m.xz_x0 = getPreferenceX(696f, xz.getWidth());
                m.xz_y0 = getPreferenceY(201, xz.getHeight());
//                while (title.getHeight() < 0) Thread.sleep(10);
//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IconManager.init();
            js = resizeBitmap(js);
            RandomThread.width = js.getWidth();
            wm = resizeBitmap(wm);
            xc = resizeBitmap(xc);
            xz = resizeBitmap(xz);
            yy = resizeBitmap(yy);
            m.setWidth(wm.getWidth());
            titleBitmap = resizeBitmap(titleBitmap);
            titleBitmap1 = resizeBitmap(titleBitmap1);
            while (center.getHeight() <= 0)
                continue;
            isInited = true;
            while (center.getHeight() <= 0) continue;
            center.setX(m.screen_width / 2 - center.getWidth() / 2);
            center.setY(m.screen_height / 2 - center.getHeight() / 2);
            Bitmap bitmaps[] = {js, wm, xc, xz, yy};
            views = new ImageView[imageviewId.length];
            for (int i = 0; i < views.length; i++) {
                views[i] = (ImageView) findViewById(imageviewId[i]);
                views[i].setImageBitmap(bitmaps[i]);
            }

            title.setImageBitmap(titleBitmap);
            title1.setImageBitmap(titleBitmap1);

            title.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int) getPreference(titleBitmap.getWidth()) * 2 / 3, (int) getPreference(titleBitmap.getHeight()) * 2 / 3));
            title1.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int) getPreference(titleBitmap1.getWidth()) * 2 / 3, (int) getPreference(titleBitmap1.getHeight()) * 2 / 3));
            while (title.getHeight() != (int) getPreference(titleBitmap.getHeight()) * 2 / 3)
                continue;
            title.setX(getPreferenceX(69, title.getWidth()));
            title.setY(getPreferenceY(237, title.getHeight()));
            title1.setX(getPreferenceX(69, title1.getWidth()));
            title1.setY(getPreferenceY(294, title1.getHeight()));

            for (int i = 0; i < views.length; i++) {
                final int a = i;
                views[i].setOnTouchListener(new View.OnTouchListener() {
                    private float x0 = m.getX(a), y0 = m.getY(a), x = m.getX(a), y = m.getY(a);

                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                thread.setIsChanged(true);
                                x0 = motionEvent.getRawX();
                                y0 = motionEvent.getRawY();
//                                if (a != 0 && a != 2 && a != 3 && a != 4)
//                                    new AlertDialog.Builder(MainActivity.this).setTitle("").setMessage(Strings.strings[a]).setPositiveButton("是", null).show();
//                                Snackbar.make(view, Strings.strings[a], Snackbar.LENGTH_SHORT)
//                                        .setAction("Action", null).show();
                                break;
                            case MotionEvent.ACTION_MOVE:
                                float tx = motionEvent.getRawX();
                                float ty = motionEvent.getRawY();
                                if (Math.abs(tx - x0) >= 10 && Math.abs(ty - y0) >= 10) {
                                    x = tx;
                                    y = ty;
                                    thread.addEvent(new HomeThread.MyEvent(a, 0, x - x0, y - y0));
                                    x0 = x;
                                    y0 = y;
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                thread.setIsChanged(false);
                                x0 = m.getX(a);
                                y0 = m.getY(a);
                                x = m.getX(a);
                                y = m.getY(a);
                                thread.addEvent(new HomeThread.MyEvent(a, 1, 0, 0));
                                click(a);
                                break;
                        }
                        return true;
                    }
                });
//                views[i].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Snackbar.make(view, Strings.strings[a], Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//                });
            }
            startFresh = true;
            updateUI();
        }
    }

    public Bitmap resizeBitmap(Bitmap bitmap) {
        return resizeBitmap(bitmap, m.screen_width, m.screen_height);
    }

    public Bitmap resizeBitmap(Bitmap bitmap, float w, float h) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float n = Math.min(w / bitmapWidth, h / bitmapHeight);
            Matrix matrix = new Matrix();
            matrix.postScale(n, n);
            Bitmap res = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            return res;
        } else {
            return null;
        }
    }

    public Bitmap resizeBitmap2(Bitmap bitmap, float rw, float rh) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float scale = Math.min(rw / width, rh / height);
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            Bitmap res = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            return res;
        } else {
            return null;
        }
    }

    float getPreference(float f) {
        float n = Math.min(m.screen_width / bitmapWidth, m.screen_height / bitmapHeight);
        return f * n;
    }

    float getPreferenceX(float f, float width) {
        float n = Math.min(m.screen_width / bitmapWidth, m.screen_height / bitmapHeight);
        return (f > bitmapWidth / 2) ? ((f - bitmapWidth / 2) * n + m.screen_width / 2) : (m.screen_width / 2 - (bitmapWidth / 2 - f) * n);
    }

    float getPreferenceY(float f, float height) {
        float n = Math.min(m.screen_width / bitmapWidth, m.screen_height / bitmapHeight);
        return f > bitmapHeight / 2 ? ((f - bitmapHeight / 2) * n + m.screen_height / 2) : (m.screen_height / 2 - (bitmapHeight / 2 - f) * n);
    }

    public void updateUI() {
//        if (thread.isIsChanged())
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (center.getWidth() != m.screen_width)
                    center.setMinimumWidth(m.screen_width);
                bitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap);
                canvas.drawBitmap(centerImage, ((float) bitmap.getWidth() - (float) centerImage.getWidth()) / 2, ((float) bitmap.getHeight() - (float) centerImage.getHeight()) / 2, pen);
//                canvas.drawBitmap(js, m.getJs_x(), m.getJs_y(), pen);
//                canvas.drawBitmap(xz, m.getXz_x(), m.getXz_y(), pen);
//                canvas.drawBitmap(xc, m.getXc_x(), m.getXc_y(), pen);
//                canvas.drawBitmap(yy, m.getYy_x(), m.getYy_y(), pen);
//                canvas.drawBitmap(wm, m.getWm_x(), m.getWm_y(), pen);
                views[0].setX(m.getJs_x());
                views[0].setY(m.getJs_y());
                views[1].setX(m.getWm_x());
                views[1].setY(m.getWm_y());
                views[2].setX(m.getXc_x());
                views[2].setY(m.getXc_y());
                views[3].setX(m.getXz_x());
                views[3].setY(m.getXz_y());
                views[4].setX(m.getYy_x());
                views[4].setY(m.getYy_y());


                // center.setImageBitmap(bitmap);
            }
        });
    }

    private void click(int i) {
        switch (i) {
            case 0:
                //TODO to jishubu
                Intent jsIntent = new Intent(this, JSMainActivity2.class);
                startActivity(jsIntent);
                break;
            case 1:
                //TODO to Waimeibu
                Intent wmintent = new Intent(MainActivity.this,JSShowPicActivity.class);
                wmintent.setFlags(R.drawable.wmb);
                startActivity(wmintent);
                break;
            case 2:
//                Intent xcintent = new Intent(MainActivity.this, JSShowPicActivity.class);
//                xcintent.setFlags(R.drawable.xuanchuan);
//                startActivity(xcintent);
                Intent xcintent = new Intent(MainActivity.this, ImgSwitchActivity.class);
                startActivity(xcintent);
                break;
            case 3:
                //TODO to Xingzheng
                Intent xzintent = new Intent(MainActivity.this,JSShowPicActivity.class);
                xzintent.setFlags(R.drawable.xzb);
                startActivity(xzintent);
                break;
            case 4:
                Intent yyintent = new Intent(this, JSShowPicActivity.class);
                yyintent.setFlags(R.drawable.bbs);
                startActivity(yyintent);
                break;
        }
    }

    class MyTouchListener implements View.OnTouchListener {
        private boolean flag1, flag2, flag3, flag4, flag5;

        public boolean onTouch(View var1, MotionEvent var2) {
            switch (var2.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (isInJs(var2.getX(), var2.getY())) {
                        go(0, var2.getX(), var2.getY());
                        flag1 = true;
                    }
                    if (isInWm(var2.getX(), var2.getY())) {
                        go(1, var2.getX(), var2.getY());
                        flag2 = true;
                    }
                    if (isInXc(var2.getX(), var2.getY())) {
                        go(2, var2.getX(), var2.getY());
                        flag3 = true;
                    }
                    if (isInXz(var2.getX(), var2.getY())) {
                        go(3, var2.getX(), var2.getY());
                        flag4 = true;
                    }
                    if (isInYy(var2.getX(), var2.getY())) {
                        go(4, var2.getX(), var2.getY());
                        flag5 = true;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (flag1)
                        if (!isInJs(var2.getX(), var2.getY())) {
                            rego(0);
                            flag1 = false;
                        } else {
                            go(0, var2.getX(), var2.getY());
                            flag1 = true;
                        }
                    if (flag2)
                        if (!isInWm(var2.getX(), var2.getY())) {
                            rego(1);
                            flag2 = false;
                        } else {
                            go(1, var2.getX(), var2.getY());
                            flag2 = true;
                        }

                    if (flag3)
                        if (!isInXc(var2.getX(), var2.getY())) {
                            rego(2);
                            flag3 = false;
                        } else {
                            go(2, var2.getX(), var2.getY());
                            flag3 = true;
                        }

                    if (flag4)
                        if (!isInXz(var2.getX(), var2.getY())) {
                            rego(3);
                            flag4 = false;
                        } else {
                            go(3, var2.getX(), var2.getY());
                            flag4 = true;
                        }

                    if (flag5)
                        if (!isInYy(var2.getX(), var2.getY())) {
                            rego(4);
                            flag5 = false;
                        } else {
                            go(4, var2.getX(), var2.getY());
                            flag5 = true;
                        }
                    break;
                case MotionEvent.ACTION_UP:
                    if (flag1) {
                        rego(0);
                        flag1 = false;
                        if (isInJs(var2.getX(), var2.getY()))
                            click(0);
                    }
                    if (flag2) {
                        rego(1);
                        flag2 = false;
                        if (isInWm(var2.getX(), var2.getY()))
                            click(1);
                    }
                    if (flag3) {
                        rego(2);
                        flag3 = false;
                        if (isInXc(var2.getX(), var2.getY()))
                            click(2);
                    }
                    if (flag4) {
                        rego(3);
                        flag4 = false;
                        if (isInXz(var2.getX(), var2.getY()))
                            click(3);
                    }
                    if (flag5) {
                        rego(4);
                        flag5 = false;
                        if (isInYy(var2.getX(), var2.getY()))
                            click(4);
                    }
                    break;
            }
            return true;
        }

        private void rego(int i) {
            thread.addEvent(new HomeThread.MyEvent(i, 1, 0, 0));
        }

        private void go(int i, float x, float y) {
            Location l = getCenter(i, x, y);
            thread.addEvent(new HomeThread.MyEvent(i, 0, l.x, l.y));
        }

        private class Location {
            float x, y;

            Location(float x, float y) {
                this.x = x;
                this.y = y;
            }
        }

        private Location getCenter(int i, float x, float y) {
            float width = 0, height = 0;
            switch (i) {
                case 0:
                    width = js.getWidth();
                    height = js.getHeight();
                    break;
                case 1:
                    width = wm.getWidth();
                    height = wm.getHeight();
                    break;
                case 2:
                    width = xc.getWidth();
                    height = xc.getHeight();
                    break;
                case 3:
                    width = xz.getWidth();
                    height = xz.getHeight();
                    break;
                case 4:
                    width = yy.getWidth();
                    height = yy.getHeight();
                    break;
            }
            return new Location(x - width / 2, y - height / 2);
        }

        boolean isInJs(float x, float y) {
            return x >= m.getJs_x() && y >= m.getJs_y() && m.getJs_x() + js.getWidth() >= x && m.getJs_y() + js.getHeight() >= y;
        }

        boolean isInXc(float x, float y) {
            return x >= m.getXc_x() && y >= m.getXc_y() && m.getXc_x() + xc.getWidth() >= x && m.getXc_y() + xc.getHeight() >= y;
        }

        boolean isInXz(float x, float y) {
            return x >= m.getXz_x() && y >= m.getXz_y() && m.getXz_x() + xz.getWidth() >= x && m.getXz_y() + xz.getHeight() >= y;
        }

        boolean isInWm(float x, float y) {
            return x >= m.getWm_x() && y >= m.getWm_y() && m.getWm_x() + wm.getWidth() >= x && m.getWm_y() + wm.getHeight() >= y;
        }

        boolean isInYy(float x, float y) {
            return x >= m.getYy_x() && y >= m.getYy_y() && m.getYy_x() + yy.getWidth() >= x && m.getYy_y() + yy.getHeight() >= y;
        }
    }

    public boolean isStartFresh() {
        return startFresh;
    }
}
