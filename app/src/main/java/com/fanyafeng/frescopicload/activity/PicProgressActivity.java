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
    private SimpleDraweeView progress2;
    private SimpleDraweeView progress3;

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
        progress2 = (SimpleDraweeView) findViewById(R.id.progress2);
        progress3 = (SimpleDraweeView) findViewById(R.id.progress3);

    }

    //初始化数据
    private void initData() {
        progress1.setHierarchy(FrescoAttributeUtil.setProgressBarHierarchy(this, R.drawable.wine_loading));
        progress1.setImageURI(PicUrlConstants.imgUrl);

        progress2.setHierarchy(FrescoAttributeUtil.setCircleProgressBarHierarchy(this, R.drawable.wine_loading));
        progress2.setImageURI(PicUrlConstants.imgUrl);

//        progress3.setHierarchy(FrescoAttributeUtil.setLoadFailHierarchy(this, R.drawable.load_holder_icon, R.drawable.load_fail_icon));
        progress3.setImageURI(PicUrlConstants.imgUrl);

    }

}
