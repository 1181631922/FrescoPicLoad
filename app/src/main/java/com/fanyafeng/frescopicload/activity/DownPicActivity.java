package com.fanyafeng.frescopicload.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.util.FrescoDealPicUtil;

import java.util.concurrent.Executor;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class DownPicActivity extends BaseActivity {
    private SimpleDraweeView sdvDown1;
    private ImageView ivDown1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_pic);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_down_pic);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_down_pic));
    }

    //初始化UI空间
    private void initView() {
        sdvDown1 = (SimpleDraweeView) findViewById(R.id.sdvDown1);
        ivDown1 = (ImageView) findViewById(R.id.ivDown1);
    }

    //初始化数据
    private void initData() {

    }

    private void senNotifi(Bitmap bitmap) {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title)
                .setContentText("消息详细内容嘻嘻嘻嘻嘻嘻嘻嘻嘻")
//                .setContentIntent(contentIntent)
                .setTicker(this.getString(R.string.app_name) + "消息")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.icon_progress_bar)
//                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
//                        R.mipmap.ic_launcher));
                .setLargeIcon(bitmap);

        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), notification);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnDownPic1:
                downPic();
                break;
            case R.id.btnShowPic1:
                break;
            case R.id.btnNoti1:
//                senNotifi();
                break;
        }
    }

    private void downPic() {
        Uri uri = Uri.parse("http://tiyanzhimei.com/wp-content/uploads/2015/08/121.jpg");

        ImageDecodeOptions decodeOptions = ImageDecodeOptions.newBuilder()
                .setBackgroundColor(Color.GRAY)
                .build();
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setImageDecodeOptions(decodeOptions)
                .setAutoRotateEnabled(true)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .setProgressiveRenderingEnabled(false)//渐进渲染
//                .setResizeOptions(new ResizeOptions(300, 300))
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, this);

        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(Bitmap bitmap) {
                //获取图片的bitmap
                Log.d("down", "down在bitmap做了点啥" + (bitmap == null));
                sdvDown1.setImageBitmap(bitmap);
                ivDown1.setImageBitmap(bitmap);
                senNotifi(bitmap);
            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {

            }
        }, UiThreadImmediateExecutorService.getInstance());


//        try {
//            CloseableReference<CloseableImage> imageCloseableReference = dataSource.getResult();
//            if (imageCloseableReference != null) {
//                try {
//                    CloseableImage closeableImage = imageCloseableReference.get();
//                    if (closeableImage != null && closeableImage instanceof CloseableStaticBitmap) {
//                        CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
//                        Bitmap bitmap = closeableStaticBitmap.getUnderlyingBitmap();
//                        if (bitmap != null) {
//                            sdvDown1.setImageBitmap(bitmap);
//                        }
//                    }
//                } finally {
//                    CloseableReference.closeSafely(imageCloseableReference);
//                }
//            } else {
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            dataSource.close();
//        }


    }
}
