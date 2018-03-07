package com.lezhi.wshi.module.ui.activitys;

import android.os.Bundle;
import android.view.KeyEvent;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.SwipeBackActivity;
import com.lezhi.wshi.utils.JumpUtil;
import com.lezhi.wshi.utils.titlebar.StatusBarUtil;

import butterknife.ButterKnife;

public class LoginActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        // 设置透明导航栏
        StatusBarUtil.setTranslucentForImageView(LoginActivity.this,38,null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            JumpUtil.overiderAnimsition(this);
            return true;
        }else{
            return super.onKeyDown(keyCode,event);
        }
    }
}
