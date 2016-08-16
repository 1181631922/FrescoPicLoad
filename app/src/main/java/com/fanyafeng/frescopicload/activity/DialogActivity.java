package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class DialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_dialog);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setVisibility(View.GONE);
        //toolbar_center_title.setText(getString(R.string.title_activity_dialog));
    }

    //初始化UI空间
    private void initView() {
        Log.d("dialog", "dialog activity");

    }

    //初始化数据
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_dialog_cancle:
                finish();
                break;
            case R.id.btn_dialog_enter:
                Toast.makeText(this, "用户点击确认", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
