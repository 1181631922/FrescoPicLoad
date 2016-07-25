package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.util.FrescoUtil;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class AppPicLoadActivity extends BaseActivity {
    private SimpleDraweeView sdv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_pic_load);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_app_pic_load);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_app_pic_load));
    }

    //初始化UI空间
    private void initView() {
        sdv1 = (SimpleDraweeView) findViewById(R.id.sdv1);
        FrescoUtil.loadPicInApp(sdv1, R.drawable.jinmu, 1.77864583f);
//        ControllerListenerUtil.setControllerListener(sdv1, String.valueOf(R.drawable.jinmu), MyUtils.getScreenWidth(this), this);
    }

    //初始化数据
    private void initData() {

    }

}
