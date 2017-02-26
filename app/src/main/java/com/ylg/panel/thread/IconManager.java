package com.ylg.panel.thread;

/**
 * Created by 天楠 on 2016/11/25.
 */

public class IconManager {
    public static IconManager iconManager = new IconManager();
    public int screen_width, screen_height;
    float js_x, js_y, xz_x, xz_y, xc_x, xc_y, wm_x, wm_y, yy_x, yy_y;
    public float js_x0, js_y0, xz_x0, xz_y0, xc_x0, xc_y0, wm_x0, wm_y0, yy_x0, yy_y0;
    float width;
    boolean flag = false;
    public void setWidth(float width){
        this.width=width;
    }

    public void setJs_x(float js_x) {
        synchronized (this) {
            if (this.js_x == js_x)
                return;
            flag = true;
            this.js_x = js_x;
        }
    }

    public void setJs_y(float js_y) {
        synchronized (this) {
            if (this.js_y == js_y)
                return;
            flag = true;
            this.js_y = js_y;
        }
    }

    public void setXz_x(float xz_x) {
        synchronized (this) {
            if (this.xz_x == xz_x)
                return;
            flag = true;
            this.xz_x = xz_x;
        }
    }

    public void setXz_y(float xz_y) {
        synchronized (this) {
            if (this.xz_y == xz_y)
                return;
            flag = true;
            this.xz_y = xz_y;
        }
    }

    public void setXc_x(float xc_x) {
        synchronized (this) {
            if (this.xc_x == xc_x)
                return;
            flag = true;
            this.xc_x = xc_x;
        }
    }

    public void setXc_y(float xc_y) {
        synchronized (this) {
            if (this.xc_y == xc_y)
                return;
            flag = true;
            this.xc_y = xc_y;
        }
    }

    public void setWm_x(float wm_x) {
        synchronized (this) {
            if (this.wm_x == wm_x)
                return;
            flag = true;
            this.wm_x = wm_x;
        }
    }

    public void setWm_y(float wm_y) {
        synchronized (this) {
            if (this.wm_y == wm_y)
                return;
            flag = true;
            this.wm_y = wm_y;
        }
    }

    public void setYy_x(float yy_x) {
        synchronized (this) {
            if (this.yy_x == yy_x)
                return;
            flag = true;
            this.yy_x = yy_x;
        }
    }

    public void setYy_y(float yy_y) {
        synchronized (this) {
            if (this.yy_y == yy_y)
                return;
            flag = true;
            this.yy_y = yy_y;
        }
    }

    public float getJs_x() {
        synchronized (this) {
            return js_x;
        }
    }

    public float getJs_y() {
        synchronized (this) {
            return js_y;
        }
    }

    public float getXz_x() {
        synchronized (this) {
            return xz_x;
        }
    }

    public float getXz_y() {
        synchronized (this) {
            return xz_y;
        }
    }

    public float getXc_x() {
        synchronized (this) {
            return xc_x;
        }
    }

    public float getXc_y() {
        synchronized (this) {
            return xc_y;
        }
    }

    public float getWm_x() {
        synchronized (this) {
            return wm_x;
        }
    }

    public float getWm_y() {
        synchronized (this) {
            return wm_y;
        }
    }

    public float getYy_x() {
        synchronized (this) {
            return yy_x;
        }
    }

    public float getYy_y() {
        synchronized (this) {
            return yy_y;
        }
    }

    public void setFlag(boolean flag) {
        synchronized (this) {
            this.flag = flag;
        }
    }


    public float getX(int i){
            switch (i) {
                case 0:
                    //TODO to jishubu
                    return getJs_x();
                case 1:
                    //TODO to Waimeibu
                    return getWm_x();
                case 2:
                    //TODO to Xuanchuan
                    return getXc_x();
                case 3:
                    //TODO to Xingzheng
                    return getXz_x();
                case 4:
                    //TODO to Yunyin
                    return getYy_x();
            }
        return 0f;
    }

    public float getY(int i){
        switch (i) {
            case 0:
                //TODO to jishubu
                return getJs_y();
            case 1:
                //TODO to Waimeibu
                return getWm_y();
            case 2:
                //TODO to Xuanchuan
                return getXc_y();
            case 3:
                //TODO to Xingzheng
                return getXz_y();
            case 4:
                //TODO to Yunyin
                return getYy_y();
        }
        return 0f;
    }
    public void setLocation(int i, float x, float y) {
        switch (i) {
            case 0:
                //TODO to jishubu
                setJs_x(x);
                setJs_y(y);
                break;
            case 1:
                //TODO to Waimeibu
                setWm_x(x);
                setWm_y(y);
                break;
            case 2:
                //TODO to Xuanchuan
                setXc_x(x);
                setXc_y(y);
                break;
            case 3:
                //TODO to Xingzheng
                setXz_x(x);
                setXz_y(y);
                break;
            case 4:
                //TODO to Yunyin
                setYy_x(x);
                setYy_y(y);
                break;
        }
    }

    public static void init() {
        IconManager m = IconManager.iconManager;
        m.js_x = m.js_x0;
        m.js_y = m.js_y0;
        m.xc_x = m.xc_x0;
        m.xc_y = m.xc_y0;
        m.xz_x = m.xz_x0;
        m.xz_y = m.xz_y0;
        m.yy_x = m.yy_x0;
        m.yy_y = m.yy_y0;
        m.wm_x = m.wm_x0;
        m.wm_y = m.wm_y0;
    }
}
