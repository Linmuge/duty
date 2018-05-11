package com.gzyyu.zhiri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*list.add("周一");
        list.add("周二");
        list.add("周三");
        list.add("周四");
        list.add("周五");
        list.add("不值日");
        list.add("不值日");
        list.add("不值日");
        list.add("不值日");
        list.add("不值日");*/
        Intent intent = getIntent();
        list = intent.getStringArrayListExtra("list");
        Log.d("123", "onCreate: "+list);
        final TextView num = findViewById(R.id.num);
        Button zhiri = findViewById(R.id.button);
            zhiri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (list.size()!=0){
                        int index = (int)(Math.random()*list.size());
                        String num1 = list.get(index);
                        if (num1.equals("不值日")){
                            num.setTextColor(0xffff0000);
                            num.setText(num1);
                        }else {
                            num.setTextColor(0xff000000);
                            num.setText(num1);
                        }
                        list.remove(index);
                    }else {
                        num.setTextColor(0xff8B2252);
                        num.setText("祝你有个好周末");
                    }
                    /*new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                OkHttpClient client = new OkHttpClient();
                                RequestBody requestBody = new FormBody.Builder().build();
                                Request request = new Request.Builder().url("http://192.168.100.105:8080/tz/searchInfo.do").post(requestBody).build();
                                Response response = client.newCall(request).execute();
                                String re = response.body().string();
                                Message message = handler.obtainMessage();
                                message.arg1 = 1;
                                message.obj = re;
                                handler.sendMessage(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();*/
                }
            });
    }
    /*@SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1){
                case 1:
                    String re = msg.obj.toString();
                    Log.d("MainActivity", "handleMessage: "+re);
                    break;
            }
        }
    };*/
}
