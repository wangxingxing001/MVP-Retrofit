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
import com.lezhi.wshi.widget.theme.Theme;

import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Author: {王二星}
 * Description: BaseActivity
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity {
    private final String TAG = "BaseActivity";
    protected Unbinder unbinder;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.LogE(TAG,"------>onCreate");
        init();
    }

    protected void init() {
        setTranslucentStatus(true);
        BaseApplication.getInstance().registerActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        setTitleHeight(getRootView(this));
        LogUtil.LogE(TAG,"------>onStart");
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
}
