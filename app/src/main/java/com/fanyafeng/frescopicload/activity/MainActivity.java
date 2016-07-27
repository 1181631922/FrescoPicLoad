package com.fanyafeng.frescopicload.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
//        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_center_title.setText(getString(R.string.title_activity_main));
    }

    //初始化UI空间
    private void initView() {

    }

    //初始化数据
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnOperate1://app内图片加载
                startActivity(new Intent(this, AppPicLoadActivity.class));
                break;
            case R.id.btnOperate2:
                startActivity(new Intent(this, AppGifPicLoadActivity.class));
                break;
            case R.id.btnOperate3:
                startActivity(new Intent(this, CirclePicActivity.class));
                break;
            case R.id.btnOperate4:
                startActivity(new Intent(this, PicProgressActivity.class));
                break;
        }
    }
}
