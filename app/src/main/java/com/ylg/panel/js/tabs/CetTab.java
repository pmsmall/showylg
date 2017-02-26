package com.ylg.panel.js.tabs;

/**
 * Created by 涛江 on 2016/11/25.
 */

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ylg.panel.R;
import com.ylg.panel.httpUtil.HttpHelper;

import org.json.JSONException;

import java.io.IOException;

public class CetTab extends Fragment implements View.OnClickListener {
    /**
     * time:2016-11-04 13:40:01
     * add by li
     * content:add click event
     */
    private static final int NOT_FOUND_RESULT = 0;
    private static final int FOUND_RESULT = 1;

    private EditText et_cetSearch; // for input
    private Button bt_cetSearch;   // for submit
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FOUND_RESULT:
                    Bundle data = msg.getData();
                    String result = data.getString("result");
                    new android.support.v7.app.AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage(result).setPositiveButton("是", null).show();
                    et_cetSearch.setText("");
                    break;
                case NOT_FOUND_RESULT:
                    new android.support.v7.app.AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage("云云竭尽全力了，还是没有找到QAQ").setPositiveButton("是", null).show();
                    et_cetSearch.setText("");
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.js_fragment_cet, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        initView();
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cet);
//
//        initView();
//    }
    private void initView() {
        et_cetSearch = (EditText) getView().findViewById(R.id.et_cetSearch);
        bt_cetSearch = (Button) getView().findViewById(R.id.bt_cetSearch);
        bt_cetSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_cetSearch:// 查询按钮点击事件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result;
                        try {
                            result = HttpHelper.getCetRequest(getContext(), et_cetSearch.getText().toString());
//                            Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
                            Log.d("result",result);
                            Message message = new Message();
                            message.what = FOUND_RESULT;
                            Bundle data = new Bundle();
                            data.putString("result",result);
                            message.setData(data);
                            handler.sendMessage(message);
//                            new AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage(result).setPositiveButton("是", null).show();
                        } catch (JSONException | IOException e) {
                            Message message = new Message();
                            message.what = NOT_FOUND_RESULT;
                            handler.sendMessage(message);
//                            new AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage("云云竭尽全力了，还是没有找到QAQ").setPositiveButton("是", null).show();
//                            Toast.makeText(getContext(), "云云竭尽全力了，还是没有找到QAQ", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            default:
                break;


        }
    }
}

