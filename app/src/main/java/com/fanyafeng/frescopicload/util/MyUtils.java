package com.fanyafeng.frescopicload.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyUtils {
    private static String channel = null;

    //    获取虚拟按键高度
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static String getChannel(Context context) {
        if (channel == null) {
            ApplicationInfo ai = null;
            channel = "shape_maintext_box";
            try {
                ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);

                if (ai != null) {
                    channel = String.valueOf(ai.metaData.get("UMENG_CHANNEL"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return channel;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            @SuppressWarnings("rawtypes")
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");

            int id = Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Get the screen height.
     *
     * @param context
     * @return the screen height
     */
    public static int getScreenHeight(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);

            return displayMetrics.heightPixels;
        } else {
            return 1920;
        }
    }

    /**
     * Get the screen width.
     *
     * @param context
     * @return the screen width
     */
    public static int getScreenWidth(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);

            return displayMetrics.widthPixels;
        } else {
            return 1080;
        }
    }

    public static float getDensity(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static String getMetaValue(Context context, String metaKey) {

        if (context == null || metaKey == null) {
            return null;
        }

        try {
            ApplicationInfo aiApplicationInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);

            if (null != aiApplicationInfo) {
                if (null != aiApplicationInfo.metaData) {
                    return aiApplicationInfo.metaData.getString(metaKey);
                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化日期
     * yyyy-MM-dd 转为 yyyy年MM月dd日
     *
     * @param dateStr
     * @return
     */
    public static String formatSystemDateCN(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String standarTime;

            Date date = simpleDateFormat.parse(dateStr);
            simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            standarTime = simpleDateFormat.format(date);

            return standarTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    private Spanned dealTag(String str1, String str) {
        String[] array = str.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("祈福");
        sb.append("<b><font color=\"#ff6600\">" + str1 + "</font></b>");
        sb.append("<b>" + " 司掌" + "</b>");
        for (String s : array) {
            sb.append("<b><font color=\"#ff6600\">" + " [ " + s + " ]" + "</font></b>");
        }
        return Html.fromHtml(sb.toString());
    }

    /**
     * 第二个参数为圆角的角度
     *
     * @param bitmap
     * @param pixels
     * @return
     */
    public static Bitmap getRoundAngleImage(Bitmap bitmap, int pixels, boolean recycleOld) {
        Bitmap output = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final RectF rectF = new RectF(rect);
            final float roundPx = pixels;

            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
//            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (recycleOld)
                bitmap.recycle();
            return output;
        }
        return output;
    }

    public static Bitmap getRoundImage(Bitmap oriImg, boolean recycleOld) {

        Bitmap targetBitmap = null;

        if (oriImg != null && !oriImg.isRecycled()) {
            int size = Math.min(oriImg.getWidth(), oriImg.getHeight());
            int targetWidth = size;
            int targetHeight = size;

            targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(targetBitmap);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawCircle(targetWidth / 2f, targetHeight / 2f, targetWidth / 2f, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(oriImg, new Rect(0, 0, size, size), new Rect(0, 0, targetWidth, targetHeight), paint);

            if (recycleOld) {
                oriImg.recycle();
            }
        }
        return targetBitmap;
    }
}
