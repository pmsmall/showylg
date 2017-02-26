package com.ylg.panel.xz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.ylg.panel.R;

/**
 * @project YunLuGu
 * @package com.xiaobing.yunlugu
 * @name HuoDong3
 * @autor Xiaobing
 * @date 2016-11-25 ����5:20:58
 * @version 1.0
 * @description TODO
 */
public class HuoDong3 extends Activity {
	private ViewFlipper flipper;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.huodong3);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		flipper = (ViewFlipper) findViewById(R.id.huodong3_flipper);
		flipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_in));
		flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_out));
		flipper.setFlipInterval(3000);
		addImages();
		flipper.setAutoStart(true);
		flipper.startFlipping();
	}

	private void addImages() {
		flipper.addView(addTextByText("每半学期招新后的一到两周之内，我们都会举办“新老员工见面会”，旨在帮助新员工快速融入工作室热情的集体，并且会由行政部部长对新员工进行制度培训。麓麓发一些最近一次秋招见面会的帅照给你们饱饱眼福。"));
		flipper.addView(addImageById(R.drawable.img12));
		flipper.addView(addImageById(R.drawable.img13));
		flipper.addView(addTextByText("云麓谷帅气的指导老师在见面会上发表了重要讲话，流露出对我们的殷切的期望与祝福。并指出云麓谷是一个“你有才能，我给空间”的平台，是金子，都可以在云麓谷发光发亮。"));
		flipper.addView(addImageById(R.drawable.img14));
		flipper.addView(addTextByText("总监，部长讲话，暨制度培训"));
		flipper.addView(addImageById(R.drawable.img15));
		flipper.addView(addTextByText("最后，是我们的技术部全家福"));
		flipper.addView(addImageById(R.drawable.img16));

	}

	public View addTextByText(String text) {
		TextView tv = new TextView(this);
		tv.setText(text);
		tv.setGravity(1);
		return tv;
	}

	public View addImageById(int id) {
		ImageView iv = new ImageView(this);
		iv.setImageResource(id);

		return iv;
	}

}
