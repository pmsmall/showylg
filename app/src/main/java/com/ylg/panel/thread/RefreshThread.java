package com.ylg.panel.thread;

import com.ylg.panel.MainActivity;

/**
 * Created by 天楠 on 2016/11/25.
 */

public class RefreshThread extends Thread {
    MainActivity main;

    static boolean startFresh=false;

    public RefreshThread(MainActivity main) {
        this.main = main;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                if(startFresh=main.isStartFresh()){
                    main.updateUI();
                    IconManager.iconManager.setFlag(false);
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
