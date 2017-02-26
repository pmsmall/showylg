package com.ylg.panel.thread;

/**
 * Created by 天楠 on 2016/11/25.
 */

public class RandomThread extends Thread {
    public static volatile float width = 100;
    HomeThread home;
    boolean needReinit = false;

    public RandomThread(HomeThread home) {
        this.home = home;
    }
    IconManager m = IconManager.iconManager;
    float[] random={getRandom(),getRandom(),getRandom(),getRandom(),getRandom(),getRandom(),getRandom(),getRandom(),getRandom(),getRandom()};

    public void run() {
        int t=0;
        while (true) {
            if (!home.isIsChanged()&&RefreshThread.startFresh)
//                synchronized (home)
                {

                    int i=0;
                    m.js_x += random[i++];
                    m.js_y +=  random[i++];
                    m.xz_x +=  random[i++]/4;
                    m.xz_y +=  random[i++]/4;
                    m.xc_x +=  random[i++]/4;
                    m.xc_y +=  random[i++]/4;
                    m.wm_x +=  random[i++]/4;
                    m.wm_y +=  random[i++]/4;
                    m.yy_x +=  random[i++]/4;
                    m.yy_y +=  random[i++]/4;
                    check();
//                    needReinit = true;
                    t++;
                    if(t==10){
                        for(i=0;i<random.length;i++)
                            random[i]=getRandom();
                    }
                }
            else if (needReinit)
                IconManager.init();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void check(){
        int i=0;
        if(Math.abs(m.js_x-m.js_x0)>=m.width/4)
            random[0]=-random[0];
        if(Math.abs(m.js_y-m.js_y0)>=m.width/4)
            random[1]=-random[1];
        if(Math.abs(m.xz_x-m.xz_x0)>=m.width/8)
            random[2]=-random[2];
        if(Math.abs(m.xz_y-m.xz_y0)>=m.width/8)
            random[3]=-random[3];
        if(Math.abs(m.xc_x-m.xc_x0)>=m.width/8)
            random[4]=-random[4];
        if(Math.abs(m.xc_y-m.xc_y0)>=m.width/8)
            random[5]=-random[5];
        if(Math.abs(m.wm_x-m.wm_x0)>=m.width/8)
            random[6]=-random[6];
        if(Math.abs(m.wm_y-m.wm_y0)>=m.width/8)
            random[7]=-random[7];
        if(Math.abs(m.yy_x-m.yy_x0)>=m.width/8)
            random[8]=-random[8];
        if(Math.abs(m.yy_y-m.yy_y0)>=m.width/8)
            random[9]=-random[9];
    }

    private float getRandom() {
        return (int) (Math.random() * width /120 - width / 60);
    }
}
