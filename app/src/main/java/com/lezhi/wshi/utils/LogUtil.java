/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年11月20日16:39:01 
 * 
 *******************************************************************************/ 
package com.lezhi.wshi.utils;

import android.util.Log;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: log
 */
public class LogUtil {

	private static boolean flag = true;

    // TODO:打印日志
	public static void LogE(String TAG,String msg) {
		if (flag) {
			Log.e(TAG, msg);
		}
	}
	// TODO:描述状态
	public static void LogD(String TAG,String msg){
		if(flag){
			Log.e(TAG, msg);
		}
	}

	public static void LogI(String TAG,String msg) {
		if (flag) {
			Log.i(TAG, msg);
		}
	}
}
