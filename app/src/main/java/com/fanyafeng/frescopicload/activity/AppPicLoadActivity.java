package com.fanyafeng.frescopicload.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.fanyafeng.frescopicload.util.FrescoDealPicUtil;
import com.fanyafeng.frescopicload.util.FrescoUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class AppPicLoadActivity extends BaseActivity {
    private SimpleDraweeView sdv1;
    private SimpleDraweeView sdv2;

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

        sdv2 = (SimpleDraweeView) findViewById(R.id.sdv2);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        boolean isInCache = imagePipeline.isInDiskCacheSync(Uri.parse(PicUrlConstants.imgUrl));
        Log.d("isInCache", "是否在缓存中：" + isInCache);

//        sdv2.setImageBitmap();


    }

    //初始化数据
    private void initData() {
        String myPng = Environment.getExternalStorageDirectory().getPath() + File.separator + "tb"
                + File.separator + "him.jpg";
//        FrescoDealPicUtil.copyPicFile(PicUrlConstants.imgUrl, myPng, "him.jpg");
//        sdv2.setImageURI(Uri.parse("file://" + myPng));
        FrescoUtil.loadFilePic(sdv2, myPng);
    }

}
