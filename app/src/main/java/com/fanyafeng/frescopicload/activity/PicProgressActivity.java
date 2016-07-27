package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.fanyafeng.frescopicload.util.FrescoAttributeUtil;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class PicProgressActivity extends BaseActivity {
    private SimpleDraweeView progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_progress);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_pic_progress);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_pic_progress));
    }

    //初始化UI空间
    private void initView() {
        progress1 = (SimpleDraweeView) findViewById(R.id.progress1);

    }

    //初始化数据
    private void initData() {
//        progress1.setHierarchy(FrescoAttributeUtil.setCircleHierarchy(this));
//        progress1.setHierarchy(FrescoAttributeUtil.setProgressBarHierarchy(this,R.drawable.wine_loading));
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        GenericDraweeHierarchy progressBarDraweeHierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                .setRoundingParams(roundingParams)
                .setProgressBarImage(ContextCompat.getDrawable(this, R.drawable.wine_loading))
                .build();
        progress1.setHierarchy(progressBarDraweeHierarchy);
        progress1.setImageURI(PicUrlConstants.imgUrl);
    }

}
