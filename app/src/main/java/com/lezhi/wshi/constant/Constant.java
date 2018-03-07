package com.lezhi.wshi.constant;

import com.lezhi.wshi.module.BaseApplication;

import java.io.File;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 公用参数
 */
public class Constant {

    public static String  ERROR_TITLE="网络连接异常";
    public static String  ERROR_CONTEXT="请检查网络后重试";
    public static String  ERROR_BUTTON="重试";

    public static String EMPTY_TITLE="没有找到数据";
    public static String EMPTY_CONTEXT="换个条件试试吧";
    // 开启Log模式
    public static final boolean DEBUG = Boolean.parseBoolean("true");

    // 路径
    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";

    // 服务器路径
    public static final String BASE_URL = "";


}
