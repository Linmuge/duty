package com.gzyyu.zhiri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SeleteActivity extends AppCompatActivity {

    private CheckBox vz1,vz2,vz3,vz4,vz5,vz6,vz7;
    private Button done;
    private EditText person;
    private List<Boolean> checkBoxList;
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selete);
        initView();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                Log.d("1234", "onClick: "+list.size());
                String p1 = person.getText().toString();
                int p ;
                if (p1.equals("")){
                    p=10;
                }else {
                    p =  Integer.parseInt(p1);
                }
                int j = p - list.size();
                for (int i = 0; i < j ; i++) {
                    list.add("不值日");
                }
                Intent intent = new Intent(SeleteActivity.this,MainActivity.class);
                /*Bundle bundle = new Bundle();
                bundle.putStringArrayList("list",list);*/
                intent.putExtra("list",list);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initData() {
        if (vz1.isChecked()){
            list.add("周一");
        }
        if (vz2.isChecked()){
            list.add("周二");
        }
        if (vz3.isChecked()){
            list.add("周三");
        }
        if (vz4.isChecked()){
            list.add("周四");
        }
        if (vz5.isChecked()){
            list.add("周五");
        }
        if (vz6.isChecked()){
            list.add("周六");
        }
        if (vz7.isChecked()){
            list.add("周日");
        }
    }

    private void initView() {
        vz1 = findViewById(R.id.checkBox1);
        vz2 = findViewById(R.id.checkBox2);
        vz3 = findViewById(R.id.checkBox3);
        vz4 = findViewById(R.id.checkBox4);
        vz5 = findViewById(R.id.checkBox5);
        vz6 = findViewById(R.id.checkBox6);
        vz7 = findViewById(R.id.checkBox7);
        done = findViewById(R.id.button2);
        person = findViewById(R.id.editText);
    }
}
