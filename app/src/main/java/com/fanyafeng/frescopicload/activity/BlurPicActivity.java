package com.fanyafeng.frescopicload.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.fanyafeng.frescopicload.util.FrescoDealPicUtil;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class BlurPicActivity extends BaseActivity {
    private SimpleDraweeView sdvBlur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_pic);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_blur_pic);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        toolbar_center_title.setText(getString(R.string.title_activity_blur_pic));
    }

    //初始化UI空间
    private void initView() {
        sdvBlur = (SimpleDraweeView) findViewById(R.id.sdvBlur);
    }

    //初始化数据
    private void initData() {
        FrescoDealPicUtil.loadUrlInBlur(PicUrlConstants.imgUrl, sdvBlur, 0, 0, this, 30, 2);
//        sdvBlur.setImageURI(PicUrlConstants.imgUrl);
//        FrescoDealPicUtil.load(Uri.parse(PicUrlConstants.imgUrl), sdvBlur, null, 0, 0, null);
    }

}
