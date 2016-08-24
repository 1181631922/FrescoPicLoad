package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.util.FrescoUtil;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class AppGifPicLoadActivity extends BaseActivity {
    private SimpleDraweeView sdvGifApp;
    private SimpleDraweeView sdvNetGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_gif_pic_load);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_app_gif_pic_load);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_app_gif_pic_load));
    }

    //初始化UI空间
    private void initView() {
        sdvGifApp = (SimpleDraweeView) findViewById(R.id.sdvGifApp);
        sdvNetGif = (SimpleDraweeView) findViewById(R.id.sdvNetGif);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadGifPicOnNet(sdvNetGif, "http://img32.mtime.cn/up/2013/07/20/142428.27146212_500.jpg");
        FrescoUtil.loadGifPicInApp(sdvGifApp, R.drawable.circle);
    }

}
