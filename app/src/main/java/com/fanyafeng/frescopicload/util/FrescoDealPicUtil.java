package com.fanyafeng.frescopicload.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;

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
import com.fanyafeng.frescopicload.constant.PicUrlConstants;

/**
 * Author： fanyafeng
 * Data： 16/7/28 10:57
 * Email: fanyafeng@live.cn
 */
public class FrescoDealPicUtil {
    /**
     * 裁剪图片
     *
     * @param simpleDraweeView
     * @param picUrl
     * @param showWidth，需要显示的图片的宽度
     * @param showHeight，需要显示图片的高度
     * @param cutWidth，裁剪图片的宽的起点
     * @param cutHeight，裁剪图片高的起点
     */
    public static void getCutedPic(SimpleDraweeView simpleDraweeView, String picUrl, final int showWidth, final int showHeight, final int cutWidth, final int cutHeight) {
        Postprocessor postprocessor = new BasePostprocessor() {
            @Override
            public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                CloseableReference<Bitmap> bitmapRef = bitmapFactory.createBitmap(
                        showWidth,
                        showHeight);
                int aimWidth = sourceBitmap.getWidth() - cutWidth;
                int aimHeight = sourceBitmap.getHeight() - cutHeight;
                try {
                    Bitmap destBitmap = bitmapRef.get();
                    for (int x = 0; x < showWidth; x++) {
                        for (int y = 0; y < showHeight; y++) {
                            destBitmap.setPixel(x, y, sourceBitmap.getPixel(aimWidth + x, aimHeight + y));
                        }
                    }

                    return CloseableReference.cloneOrNull(bitmapRef);
                } finally {
                    CloseableReference.closeSafely(bitmapRef);
                }
            }
        };
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(picUrl))
                .setPostprocessor(postprocessor)
                .build();
        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(pipelineDraweeController);
    }

    /**
     * 图片加水印(字)
     *
     * @param simpleDraweeView
     * @param imgUrl
     * @param mark             需要加的水印，限制为字
     * @param color            水印字体颜色
     * @param alpha            水印透明度
     */
    public static void setTextWaterMark(SimpleDraweeView simpleDraweeView, String imgUrl, final String mark, final int color, final int alpha) {
        Postprocessor postprocessor = new BasePostprocessor() {
            @Override
            public void process(Bitmap bitmap) {
                super.process(bitmap);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setStrokeWidth(10);
                String familyName = "楷体";
                Typeface font = Typeface.create(familyName, Typeface.BOLD);
                paint.setColor(color);
                paint.setTypeface(font);
                paint.setTextSize(60);
                paint.setAlpha(alpha);
                Rect rect = new Rect();
                paint.getTextBounds(mark, 0, mark.length(), rect);
                int textWidth = rect.width();
                canvas.drawText(mark, width - textWidth - 50, height - 50, paint);
            }
        };
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imgUrl))
                .setPostprocessor(postprocessor)
                .build();
        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(pipelineDraweeController);
    }

    /**
     * 图片加水印(图)
     *
     * @param context
     * @param simpleDraweeView
     * @param picUrl
     * @param picId            水印图的id
     */
    public static void setPicWaterMark(final Context context, SimpleDraweeView simpleDraweeView, String picUrl, final int picId) {
        Postprocessor postprocessor = new BasePostprocessor() {
            @Override
            public void process(Bitmap bitmap) {
                super.process(bitmap);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setAlpha(255);
                Bitmap bitma = BitmapFactory.decodeResource(context.getResources(), picId);
                int markWidth = bitma.getWidth();
                canvas.drawBitmap(bitma, width - markWidth - 50, 50, paint);
            }
        };
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(picUrl))
                .setPostprocessor(postprocessor)
                .build();
        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(pipelineDraweeController);
    }
}
