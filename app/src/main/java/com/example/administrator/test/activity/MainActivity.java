package com.example.administrator.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.test.R;

/**
 * 人品计算器
 * 2017年12月8日19:44:02
 */
public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        et_name = (EditText) findViewById(R.id.et_name);
        rg = (RadioGroup) findViewById(R.id.rg);
    }

    public void calculator(View view) {
        String name = et_name.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "please input the name", Toast.LENGTH_SHORT).show();
            return;
        }
        int sex = 0;
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rb_male:
                sex = 1;
                break;
            case R.id.rb_female:
                sex = 2;
                break;
            case R.id.rb_other:
                sex = 3;
                break;
        }
        if (sex == 0) {
            Toast.makeText(this, "please check the sex", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("sex", sex);
        startActivity(intent);
    }
}
