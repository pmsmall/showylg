package com.ylg.panel.xz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

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
public class HuoDongActivity extends Activity implements OnClickListener {
	private ViewFlipper flipper;
	private Button next;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.huodong);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		flipper = (ViewFlipper) findViewById(R.id.huodong_flipper);
		flipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_in));
		flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_out));
		next = (Button) findViewById(R.id.huodong_next);
		next.setOnClickListener(this);
		flipper.setFlipInterval(3000);
		addImages();
		flipper.setAutoStart(true);
		flipper.startFlipping();
	}

	private void addImages() {
		flipper.addView(addImageById(R.drawable.img1));
		flipper.addView(addImageById(R.drawable.img2));
		flipper.addView(addImageById(R.drawable.img3));
		flipper.addView(addImageById(R.drawable.img4));
		flipper.addView(addImageById(R.drawable.img5));
		flipper.addView(addImageById(R.drawable.img6));
		flipper.addView(addImageById(R.drawable.img7));
		flipper.addView(addImageById(R.drawable.img8));
		flipper.addView(addImageById(R.drawable.img9));

	}

	public View addImageById(int id) {
		ImageView iv = new ImageView(this);
		iv.setImageResource(id);

		return iv;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.huodong_next) {
			flipper.stopFlipping();
			startActivity(new Intent(this, HuoDong2.class));
			finish();
		}
	}
}
