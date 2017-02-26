package com.ylg.panel.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 天楠 on 2016/11/25.
 */

public class HomeThread extends Thread {

    private List<MyEvent> eventQueue = new LinkedList<>();
    private volatile boolean  isChanged = false;
    private IconManager m = IconManager.iconManager;
    private RandomThread randomThread;

    public HomeThread() {
        randomThread = new RandomThread(this);
    }

    public void run() {
        randomThread.start();
        while (true) {
            if (!eventQueue.isEmpty()) {
                randomThread.needReinit = false;

                MyEvent event = dequeueEvent();
//                synchronized (this) {
                    switch (event.who) {
                        case 0:
                            switch (event.type) {
                                case 0:

                                    m.setJs_x(m.getJs_x() + event.arg);
                                    m.setJs_y(m.getJs_y() + event.arg1);
                                    break;
                                case 1:
                                    m.setJs_x(m.js_x0);
                                    m.setJs_y(m.js_y0);
                                    break;
                            }

                            break;
                        case 1:
                            switch (event.type) {
                                case 0:
                                    m.setWm_x(m.getWm_x() + event.arg);
                                    m.setWm_y(m.getWm_y() + event.arg1);
                                    break;
                                case 1:
                                    m.setWm_x(m.wm_x0);
                                    m.setWm_y(m.wm_y0);
                                    break;
                            }

                            break;
                        case 2:
                            switch (event.type) {
                                case 0:
                                    m.setXc_x(m.getXc_x() + event.arg);
                                    m.setXc_y(m.getXc_y() + event.arg1);
                                    break;
                                case 1:
                                    m.setXc_x(m.xc_x0);
                                    m.setXc_y(m.xc_y0);
                                    break;
                            }
                            break;
                        case 3:
                            switch (event.type) {
                                case 0:
                                    m.setXz_x(m.getXz_x() + event.arg);
                                    m.setXz_y(m.getXz_y() + event.arg1);
                                    break;
                                case 1:
                                    m.setXz_x(m.xz_x0);
                                    m.setXz_y(m.xz_y0);
                                    break;
                            }
                            break;
                        case 4:
                            switch (event.type) {
                                case 0:
                                    m.setYy_x(m.getYy_x() + event.arg);
                                    m.setYy_y(m.getYy_y() + event.arg1);
                                    break;
                                case 1:
                                    m.setYy_x(m.yy_x0);
                                    m.setYy_y(m.yy_y0);
                                    break;
                            }
                            break;
                    }
//                }
            }
//            try{
//                Thread.sleep(10);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
    }

    public void addEvent(MyEvent event) {
        synchronized (eventQueue) {
            if (event != null)
                eventQueue.add(event);
        }
    }

    public MyEvent dequeueEvent() {
        synchronized (eventQueue) {
            return eventQueue.remove(0);
        }
    }

    public void setIsChanged(boolean isChanged) {
        synchronized (this) {
            this.isChanged = isChanged;
        }
    }

    public boolean isIsChanged() {
        synchronized (this) {
            return isChanged;
        }
    }

    public static class MyEvent {
        int who;
        int type;
        float arg;
        float arg1;

        public MyEvent(int who, int type, float arg, float arg1) {
            this.who = who;
            this.type = type;
            this.arg = arg;
            this.arg1 = arg1;
        }
    }
}
