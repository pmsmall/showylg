package com.ylg.panel.xz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.ylg.panel.R;

/**
 * @project YunLuGu
 * @package com.xiaobing.yunlugu
 * @name DiWeiActivity
 * @autor Xiaobing
 * @date 2016-11-25 ����1:27:04
 * @version 1.0
 * @description TODO
 */
public class DiWeiActivity extends Activity{
	private TextView title,t1,t2,t3,t4;
	private int x,y;
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	      setContentView(R.layout.diwei);
	      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	      title = (TextView) findViewById(R.id.diwei_title);
	      t1 = (TextView) findViewById(R.id.diwei_text1);
	      t2 = (TextView) findViewById(R.id.diwei_text2);
	      t3 = (TextView) findViewById(R.id.diwei_text3);
	      t4 = (TextView) findViewById(R.id.diwei_text4);
	      Display d = getWindowManager().getDefaultDisplay();
	      x = (int) title.getX();
	      y = 0-title.getWidth();
	     Handler handler = new Handler();
	     handler.post(new Runnable() {
			
			@Override
			public void run() {
				TranslateAnimation translate1 = new TranslateAnimation(x, x,-200,0);
				translate1.setDuration(1000);
				title.setAnimation(translate1);
				TranslateAnimation translate2 = new TranslateAnimation(0-t1.getWidth(), 0, t1.getY(), t1.getY());
				translate2.setDuration(1000);
				t1.setAnimation(translate2);
				TranslateAnimation translate3 = new TranslateAnimation(0-t2.getWidth(), 0, t2.getY(), t2.getY());
				translate3.setDuration(1500);
				t2.setAnimation(translate3);
				TranslateAnimation translate4 = new TranslateAnimation(0-t3.getWidth(), 0, t3.getY(), t3.getY());
				translate4.setDuration(2000);
				t3.setAnimation(translate4);
				TranslateAnimation translate5 = new TranslateAnimation(0-t4.getWidth(), 0, t4.getY(), t4.getY());
				translate5.setDuration(2500);
				t4.setAnimation(translate5);
				
			}
		});
		 }
}
