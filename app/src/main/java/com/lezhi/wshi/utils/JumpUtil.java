package com.lezhi.wshi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.lezhi.wshi.R;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 泛性类跳转
 */

public class JumpUtil {

    // 泛型跳转方法
    public static void jump(Context a, Class<?> clazz) {
        Intent intent = new Intent(a, clazz);
        a.startActivity(intent);
    }

    // 切入动画
    public static void overiderAnimsition(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.base_slide_right_in,R.anim.base_slide_right_out);
    }

}
