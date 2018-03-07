package com.lezhi.wshi.module.ui.activitys;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.BaseActivity;
import com.lezhi.wshi.module.ui.view.MainView;
import com.lezhi.wshi.utils.titlebar.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_view)
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        // 设置透明导航栏
        StatusBarUtil.setTranslucentForImageView(MainActivity.this,38,null);
    }

}
