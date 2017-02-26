package com.ylg.panel.js.tabs;

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
import android.widget.Toast;

import com.ylg.panel.R;
import com.ylg.panel.httpUtil.HttpHelper;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by lenovo on 2017/2/20.
 */

public class TeacherTab extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private EditText et_teacherSearch;
    private Button bt_teacherSearch;
    private int type = 0;

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
                    et_teacherSearch.setText("");
                    break;
                case NOT_FOUND_RESULT:
                    new android.support.v7.app.AlertDialog.Builder(getContext()).setTitle("查找结果").setMessage("云云竭尽全力了，还是没有找到QAQ").setPositiveButton("是", null).show();
                    et_teacherSearch.setText("");
                    break;
            }
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        //sp_percentSearchType = (Spinner) getView().findViewById(R.id.sp_percentSearchType);
        //sp_percentSearchType.setOnItemSelectedListener(this);
        et_teacherSearch = (EditText) getView().findViewById(R.id.et_teacherSearch);
        bt_teacherSearch = (Button) getView().findViewById(R.id.bt_teacherSearch);
        bt_teacherSearch.setOnClickListener(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.js_fragment_teacher, container, false);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        type = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getContext(), "请选择", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_teacherSearch:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result ="";
                        try {
                            result = HttpHelper.getTeaherRequest(getContext(), et_teacherSearch.getText().toString());
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
}
