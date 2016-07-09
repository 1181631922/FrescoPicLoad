package com.fanyafeng.frescopicload.util.frscoutil;

import android.net.Uri;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Author： fanyafeng
 * Data： 16/7/9 12:04
 * Email: fanyafeng@live.cn
 */
public class FrescoUtil {
    /**
     * 加载app内非动图
     *
     * @param simpleDraweeView view控件
     * @param resId            资源比例
     * @param aspectRatio      图片长宽比例
     */
    public static void loadPicInApp(SimpleDraweeView simpleDraweeView, int resId, float aspectRatio) {
        if (simpleDraweeView == null)
            return;
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(resId))
                .build();
        if (aspectRatio > 0) {
            simpleDraweeView.setAspectRatio(aspectRatio);
        }
        simpleDraweeView.setImageURI(uri);
    }

    public static void loadGifPicInApp(SimpleDraweeView simpleDraweeView, int resId, float aspectRatio) {
        if (simpleDraweeView == null)
            return;

    }
}
