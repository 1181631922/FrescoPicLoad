package com.fanyafeng.frescopicload.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.fanyafeng.frescopicload.util.FrescoAttributeUtil;
import com.fanyafeng.frescopicload.util.FrescoUtil;

import java.net.SocketImpl;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class CirclePicActivity extends BaseActivity {
    private SimpleDraweeView advCircle1;
    private SimpleDraweeView advCircle2;
    private SimpleDraweeView advCircle3;
    private SimpleDraweeView advCircle4;
    private SimpleDraweeView advCircle5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_pic);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_circle_pic);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_circle_pic));
    }

    //初始化UI空间
    private void initView() {
        advCircle1 = (SimpleDraweeView) findViewById(R.id.advCircle1);
        advCircle1.setHierarchy(FrescoAttributeUtil.getFedInHierarchy(this));
        advCircle1.setImageURI(PicUrlConstants.imgUrl);

        advCircle2 = (SimpleDraweeView) findViewById(R.id.advCircle2);
        advCircle2.setHierarchy(FrescoAttributeUtil.getCircleHierarchy(this));
        advCircle2.setImageURI(PicUrlConstants.imgUrl);

        advCircle3 = (SimpleDraweeView) findViewById(R.id.advCircle3);
        advCircle3.setHierarchy(FrescoAttributeUtil.getCircleRingHierarchy(this, Color.BLUE, 5f));
        advCircle3.setImageURI(PicUrlConstants.imgUrl);

        advCircle4 = (SimpleDraweeView) findViewById(R.id.advCircle4);
        advCircle4.setHierarchy(FrescoAttributeUtil.getCircleRadiusHierarchy(this, 50f, 50f, 50f, 50f));
        advCircle4.setImageURI(PicUrlConstants.imgUrl);

        advCircle5 = (SimpleDraweeView) findViewById(R.id.advCircle5);
        advCircle5.setHierarchy(FrescoAttributeUtil.getCircleRadiusRingHierarchy(this, 50f, 10f, 50f, 10f, Color.BLUE, 5f));
        advCircle5.setImageURI(PicUrlConstants.imgUrl);
    }

    //初始化数据
    private void initData() {

    }

}
