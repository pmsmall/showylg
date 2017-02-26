package com.ylg.panel.xz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.animation.RotateAnimation;
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
public class WorkGoalActivity extends Activity{
	private TextView title,t1,t2,t3;
	private int x,y;
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	      setContentView(R.layout.workgoal);
	      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	      title = (TextView) findViewById(R.id.workgoal_title);
	      t1 = (TextView) findViewById(R.id.workgoal_text1);
	      t2 = (TextView) findViewById(R.id.workgoal_text2);
	      t3 = (TextView) findViewById(R.id.workgoal_text3);
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
				RotateAnimation r1 = new RotateAnimation(-90,0);
				r1.setDuration(2000);
				t1.setAnimation(r1);
				RotateAnimation r2 = new RotateAnimation(-90,0);
				r2.setDuration(900);
				t2.setAnimation(r2);
				RotateAnimation r3 = new RotateAnimation(-90,0);
				r3.setDuration(300);
				t3.setAnimation(r3);
			}
		 });
	 }
}
