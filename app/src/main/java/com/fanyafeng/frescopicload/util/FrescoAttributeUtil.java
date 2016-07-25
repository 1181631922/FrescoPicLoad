package com.fanyafeng.frescopicload.util;

import android.content.Context;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;

/**
 * Author： fanyafeng
 * Data： 16/7/25 17:10
 * Email: fanyafeng@live.cn
 */
public class FrescoAttributeUtil {
    private static GenericDraweeHierarchy fedInHierarchy;

    private static GenericDraweeHierarchy circleHierarchy;

    /**
     * 淡入淡出动画效果
     *
     * @param context
     * @return
     */
    public static GenericDraweeHierarchy getFedInHierarchy(Context context) {
        if (fedInHierarchy == null) {
            fedInHierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                    .setFadeDuration(300)
                    .build();
        }
        return fedInHierarchy;
    }

    /**
     * 获取圆形图片
     *
     * @param context
     * @return
     */
    public static GenericDraweeHierarchy getCircleHierarchy(Context context) {
        if (circleHierarchy == null) {
            circleHierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                    .setRoundingParams(RoundingParams.asCircle())
                    .build();
        }
        return circleHierarchy;
    }

    /**
     * 获取圆环图片
     *
     * @return
     */
    public static GenericDraweeHierarchy getCircleRingHierarchy(Context context, int ringColor, float ringWidth) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setBorder(ringColor, ringWidth);
        roundingParams.setRoundAsCircle(true);
        GenericDraweeHierarchy circleRingHierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                .setRoundingParams(roundingParams)
                .build();
        return circleRingHierarchy;
    }

    /**
     * 获取圆角图片
     *
     * @param context
     * @param topLeft
     * @param topRight
     * @param bottomRight
     * @param bottomLeft
     * @return
     */
    public static GenericDraweeHierarchy getCircleRadiusHierarchy(Context context, float topLeft, float topRight, float bottomRight, float bottomLeft) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        GenericDraweeHierarchy circleRadiusHierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                .setRoundingParams(roundingParams)
                .build();
        return circleRadiusHierarchy;
    }

    public static GenericDraweeHierarchy getCircleRadiusRingHierarchy(Context context, float topLeft, float topRight, float bottomRight, float bottomLeft, int ringColor, float ringWidth) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setBorder(ringColor, ringWidth);
        roundingParams.setCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        GenericDraweeHierarchy circleRadiusRingHierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                .setRoundingParams(roundingParams)
                .build();
        return circleRadiusRingHierarchy;
    }
}
