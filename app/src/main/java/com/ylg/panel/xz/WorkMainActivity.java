package com.ylg.panel.xz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
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
public class WorkMainActivity extends Activity {
	private TextView title, t1, t2, t3, t4;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workmain);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		title = (TextView) findViewById(R.id.workmain_title);
		t1 = (TextView) findViewById(R.id.workmain_text1);
		t2 = (TextView) findViewById(R.id.workmain_text2);
		t3 = (TextView) findViewById(R.id.workmain_text3);
		t4 = (TextView) findViewById(R.id.workmain_text4);
		Handler handler = new Handler();
		handler.post(new Runnable() {

			@Override
			public void run() {
				AlphaAnimation a1 = new AlphaAnimation(0, 1);
				a1.setDuration(1000);
				title.setAnimation(a1);
				AlphaAnimation a2 = new AlphaAnimation(0, 1);
				a2.setDuration(2000);
				t1.setAnimation(a2);
				AlphaAnimation a3 = new AlphaAnimation(0, 1);
				a3.setDuration(3000);
				t2.setAnimation(a3);
				AlphaAnimation a4 = new AlphaAnimation(0, 1);
				a4.setDuration(4000);
				t3.setAnimation(a4);
				AlphaAnimation a5 = new AlphaAnimation(0, 1);
				a5.setDuration(5000);
				t4.setAnimation(a5);		
			}
		});
	}
}
