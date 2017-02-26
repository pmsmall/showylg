package com.ylg.panel.xz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
public class BuMenActivity extends Activity implements OnClickListener {
	private Button bt1, bt2, bt3;
	private int current = 1;
	private TextView t11,t12,t13,t14,t15,t16;
	private TextView t21,t22,t23,t24,t25,t26;
	private TextView t31,t32,t33,t34,t35;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bumen);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		bt1 = (Button) findViewById(R.id.bumen_bt1);
		bt2 = (Button) findViewById(R.id.bumen_bt2);
		bt3 = (Button) findViewById(R.id.bumen_bt3);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		
		t11 = (TextView) findViewById(R.id.bumen_t11);
		t12 = (TextView) findViewById(R.id.bumen_t12);
		t13 = (TextView) findViewById(R.id.bumen_t13);
		t14 = (TextView) findViewById(R.id.bumen_t14);
		t15 = (TextView) findViewById(R.id.bumen_t15);
		t16 = (TextView) findViewById(R.id.bumen_t16);
		
		t21 = (TextView) findViewById(R.id.bumen_t21);
		t22 = (TextView) findViewById(R.id.bumen_t22);
		t23 = (TextView) findViewById(R.id.bumen_t23);
		t24 = (TextView) findViewById(R.id.bumen_t24);
		t25 = (TextView) findViewById(R.id.bumen_t25);
		t26 = (TextView) findViewById(R.id.bumen_t26);
		
		t31 = (TextView) findViewById(R.id.bumen_t31);
		t32 = (TextView) findViewById(R.id.bumen_t32);
		t33 = (TextView) findViewById(R.id.bumen_t33);
		t34 = (TextView) findViewById(R.id.bumen_t34);
		t35 = (TextView) findViewById(R.id.bumen_t35);
		
		
		}
private void yc(){
	if(current==1){
		t11.setVisibility(View.GONE);
		t12.setVisibility(View.GONE);
		t13.setVisibility(View.GONE);
		t14.setVisibility(View.GONE);
		t15.setVisibility(View.GONE);
		t16.setVisibility(View.GONE);
	}else if(current==2){
		t21.setVisibility(View.GONE);
		t22.setVisibility(View.GONE);
		t23.setVisibility(View.GONE);
		t24.setVisibility(View.GONE);
		t25.setVisibility(View.GONE);
		t26.setVisibility(View.GONE);
		
	}else if(current==3){
		t31.setVisibility(View.GONE);
		t32.setVisibility(View.GONE);
		t33.setVisibility(View.GONE);
		t34.setVisibility(View.GONE);
		t35.setVisibility(View.GONE);
	}	
}
private void xs(){
	if(current==1){
		t11.setVisibility(View.VISIBLE);
		t12.setVisibility(View.VISIBLE);
		t13.setVisibility(View.VISIBLE);
		t14.setVisibility(View.VISIBLE);
		t15.setVisibility(View.VISIBLE);
		t16.setVisibility(View.VISIBLE);
	}else if(current==2){
		t21.setVisibility(View.VISIBLE);
		t22.setVisibility(View.VISIBLE);
		t23.setVisibility(View.VISIBLE);
		t24.setVisibility(View.VISIBLE);
		t25.setVisibility(View.VISIBLE);
		t26.setVisibility(View.VISIBLE);
		
	}else if(current==3){
		t31.setVisibility(View.VISIBLE);
		t32.setVisibility(View.VISIBLE);
		t33.setVisibility(View.VISIBLE);
		t34.setVisibility(View.VISIBLE);
		t35.setVisibility(View.VISIBLE);
	}	
}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bumen_bt1:
			yc();
			current = 1;
			xs();
			break;
		case R.id.bumen_bt2:
			yc();
			current = 2;
			xs();
			break;
		case R.id.bumen_bt3:
			yc();
			current = 3;
			xs();
			break;

		default:
			break;
		}
	}
}
