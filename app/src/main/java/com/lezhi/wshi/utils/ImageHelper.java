package com.lezhi.wshi.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.lezhi.wshi.R;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 网络图片加载类
 */
public class ImageHelper {
    private static String TAG = "ImageHelper";

    /**
     * Glide 加载图片
     *  Priority 展示团片优先级
     * @param mContext
     * @param imageView
     */
    public static void loadImageBannerGlide(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url).priority(Priority.HIGH).into(imageView);
    }

    /**
     * Glide 清除内存
     *
     * @param mContext
     */
    public static void clearMoneryCache(Context mContext) {
        if (mContext != null) {
            LogUtil.LogE(TAG, "清理图片缓存");
            Glide.get(mContext).clearMemory();
            System.gc();
        }
    }

}
