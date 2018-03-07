package com.lezhi.wshi.module.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.lezhi.wshi.R;
import com.lezhi.wshi.widget.SwipeBackLayout;

import butterknife.ButterKnife;

/**
 * Author: {王二星}
 * 1、想要实现向右滑动删除Activity效果只需要继承SwipeBackActivity即可，如果当前页面含有ViewPager
 * 只需要调用SwipeBackLayout的setViewPager()方法即可
 *2、设置activity的主题为android:theme="@style/CustomTransparent
 */
public  abstract class NewSwipeBackActivity extends NewBaseActivity {
    protected SwipeBackLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResourceID());
        layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                R.layout.base_swipe, null);
        layout.attachToActivity(this);
        unbinder = ButterKnife.bind(this);
        onBaseCreate();
    }
    protected abstract int setLayoutResourceID();
    protected abstract void onBaseCreate();
}
