package com.example.administrator.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.test.R;

import java.io.UnsupportedEncodingException;

/**
 * Created by My on 2017/12/8.
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
        TextView tv_result = (TextView) findViewById(R.id.tv_result);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex", 0);

        tv_name.setText("姓名：" + name);
        byte[] buffer = null;
        try {
            switch (sex) {
                case 1:
                    tv_sex.setText("性别：男");
                    buffer = name.getBytes("utf-8");
                    break;
                case 2:
                    tv_sex.setText("性别：女");
                    buffer = name.getBytes("GBK");
                    break;
                case 3:
                    tv_sex.setText("性别：人妖");
                    buffer = name.getBytes("ISO8859-1");
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int total = 0;
        int score;
        for (int i = 0; i < buffer.length; i++) {
            total += buffer[i] & 0Xff;
        }
        score = total % 100;
        if (score < 20) {
            tv_result.setText("人品：20分以下");
        } else if (score < 40) {
            tv_result.setText("人品：20-40分之间");
        } else if (score < 60) {
            tv_result.setText("人品：40-60分之间");
        } else if (score < 80) {
            tv_result.setText("人品：60-80分之间");
        } else {
            tv_result.setText("人品：80-100分之间");
        }
    }
}
