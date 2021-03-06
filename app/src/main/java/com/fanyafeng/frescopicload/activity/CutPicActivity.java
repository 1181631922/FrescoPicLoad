package com.fanyafeng.frescopicload.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.fanyafeng.frescopicload.util.FrescoAttributeUtil;
import com.fanyafeng.frescopicload.util.FrescoDealPicUtil;

import java.net.SocketImpl;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class CutPicActivity extends BaseActivity {
    private SimpleDraweeView cut0;
    private SimpleDraweeView cut1;
    private SimpleDraweeView cut2;
    private SimpleDraweeView cut3;
    private SimpleDraweeView cut4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_pic);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_cut_pic);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_cut_pic));
    }

    //初始化UI空间
    private void initView() {
        cut0 = (SimpleDraweeView) findViewById(R.id.cut0);
        cut0.setImageURI(PicUrlConstants.imgUrl);
        cut1 = (SimpleDraweeView) findViewById(R.id.cut1);
        cut2 = (SimpleDraweeView) findViewById(R.id.cut2);
        cut3 = (SimpleDraweeView) findViewById(R.id.cut3);
        cut4 = (SimpleDraweeView) findViewById(R.id.cut4);

        Postprocessor postprocessor = new BasePostprocessor() {

            @Override
            public void process(Bitmap destBitmap, Bitmap sourceBitmap) {
                super.process(destBitmap, sourceBitmap);
//                for (int x = 0; x < destBitmap.getWidth(); x++) {
//                    for (int y = 0; y < destBitmap.getHeight(); y++) {
//                        destBitmap.setPixel(destBitmap.getWidth() - x, y, sourceBitmap.getPixel(x, y));
//                    }
//                }
            }

            @Override
            public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                CloseableReference<Bitmap> bitmapRef = bitmapFactory.createBitmap(
                        sourceBitmap.getWidth(),
                        sourceBitmap.getHeight());
                try {
                    Bitmap destBitmap = bitmapRef.get();
                    for (int x = 0; x < destBitmap.getWidth(); x++) {
                        for (int y = 0; y < destBitmap.getHeight(); y++) {
                            destBitmap.setPixel(x, y, sourceBitmap.getPixel(x - sourceBitmap.getWidth(), y));
                        }
                    }
                    return CloseableReference.cloneOrNull(bitmapRef);
                } finally {
                    CloseableReference.closeSafely(bitmapRef);
                }
            }
        };
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(PicUrlConstants.imgUrl))
                .setPostprocessor(postprocessor)
                .build();
        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(cut4.getController())
                .build();
        cut4.setController(pipelineDraweeController);

    }

    //初始化数据

    private void initData() {
        cut1.setHierarchy(FrescoAttributeUtil.setProgressBarHierarchy(this, R.drawable.wine_loading));
        FrescoDealPicUtil.getCutedPic(cut1, PicUrlConstants.imgUrl, 1280, 479, 1280, 959);
        FrescoDealPicUtil.setTextWaterMark(cut2, PicUrlConstants.imgUrl, "樊亚风", Color.WHITE, 155);
        FrescoDealPicUtil.setPicWaterMark(this, cut3, PicUrlConstants.imgUrl, R.drawable.wind);
    }

}
