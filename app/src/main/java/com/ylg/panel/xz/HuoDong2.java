package com.ylg.panel.xz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.ylg.panel.R;

/**
 * @project YunLuGu
 * @package com.xiaobing.yunlugu
 * @name HuoDong2
 * @autor Xiaobing
 * @date 2016-11-25 ����4:45:45
 * @version 1.0
 * @description TODO
 */
public class HuoDong2 extends Activity implements OnClickListener {
	private Button next;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.huodong2);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		ImageView img1 = (ImageView) findViewById(R.id.huodong2_img1);
		ImageView img2 = (ImageView) findViewById(R.id.huodong2_img2);
		next = (Button) findViewById(R.id.huodong2_next);
		next.setOnClickListener(this);
		Display d = getWindowManager().getDefaultDisplay();
		TranslateAnimation t1 = new TranslateAnimation(img1.getX(),
				img1.getX(), d.getHeight() - 300, 0 - img1.getHeight());
		t1.setDuration(20 * 1000);
		img1.setAnimation(t1);
		TranslateAnimation t2 = new TranslateAnimation(img2.getX(),
				img2.getX(), d.getHeight() - 300, 0 - img2.getHeight());
		t2.setDuration(20 * 1000);
		img2.setAnimation(t2);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.huodong2_next) {
			startActivity(new Intent(this, HuoDong3.class));
			finish();
		}
	}
}
