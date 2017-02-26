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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ylg.panel.R;
import com.ylg.panel.httpUtil.HttpHelper;

import org.json.JSONException;

import java.io.IOException;


public class ComTab extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

  //  private Spinner sp_comSearchType;
    private EditText et_comSearch;
    private Button bt_comSearch;
    private int type = 1;
    private static final int NOT_FOUND_RESULT = 0;
    private static final int FOUND_RESULT = 1;

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FOUND_RESULT:
                    Bundle data = msg.getData();
                    String result = data.getString("result");
                    new android.support.v7.app.AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage(result).setPositiveButton("是", null).show();
                    et_comSearch.setText("");
                    break;
                case NOT_FOUND_RESULT:
                    new android.support.v7.app.AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage("云云竭尽全力了，还是没有找到QAQ").setPositiveButton("是", null).show();
                    et_comSearch.setText("");
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.js_fragment_com, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
       // sp_comSearchType = (Spinner) getView().findViewById(R.id.sp_comSearchType);
        //sp_comSearchType.setOnItemSelectedListener(this);
        et_comSearch = (EditText) getView().findViewById(R.id.et_comSearch);
        bt_comSearch = (Button) getView().findViewById(R.id.bt_comSearch);
        bt_comSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_comSearch:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result;
                        try {
                            result = HttpHelper.getComLevelRequest(getContext(), et_comSearch.getText().toString(), type);
                            Log.d("result",result);
                            Message message = new Message();
                            message.what = FOUND_RESULT;
                            Bundle data = new Bundle();
                            data.putString("result",result);
                            message.setData(data);
                            handler.sendMessage(message);
                            //Toast.makeText(this.getContext(), result, Toast.LENGTH_LONG).show();
//                            new AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage(result).setPositiveButton("是", null).show();
                        } catch (JSONException | IOException e) {
//                            new AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage("云云竭尽全力了，还是没有找到QAQ").setPositiveButton("是", null).show();
                            Message message = new Message();
                            message.what = NOT_FOUND_RESULT;
                            handler.sendMessage(message);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        type = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getContext(), "请选择", Toast.LENGTH_SHORT).show();
    }
}

