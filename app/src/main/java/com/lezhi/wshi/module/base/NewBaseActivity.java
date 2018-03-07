package com.lezhi.wshi.module.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lezhi.wshi.module.BaseApplication;
import com.lezhi.wshi.utils.LogUtil;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Author: {王二星}
 * Description: BaseActivity
 */
public abstract class NewBaseActivity<T extends BasePresenter> extends SupportActivity {

    protected Unbinder unbinder;
    protected T mPresenter;

    private final String TAG = "NewBaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.LogE(TAG,"------>onCreate");
        init();
    }

    protected void init() {
        setTranslucentStatus(true);
        // 主题变化
//        onPreCreate();
        BaseApplication.getInstance().registerActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.LogE(TAG,"------>onStart");
        // 改变 状态栏
//        setTitleHeight(getRootView(this));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.LogE(TAG,"------>onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.LogE(TAG,"------>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.LogE(TAG,"------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.LogE(TAG,"------>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.LogE(TAG,"------>onDestroy");
        BaseApplication.getInstance().unregisterActivity(this);
        if (unbinder != null)
            unbinder.unbind();
        mPresenter = null;
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

//    private void setTitleHeight(View view) {
//        if (view != null) {
//            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                if (title != null) {
//                    ViewGroup.LayoutParams lp = title.getLayoutParams();
//                    lp.height = ScreenUtil.dip2px(this, 48);
//                    title.setLayoutParams(lp);
//                    title.setPadding(0, 0, 0, 0);
//                }
//            }
//        }
//    }

    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }
}
