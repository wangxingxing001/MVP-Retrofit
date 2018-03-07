package com.lezhi.wshi.module.ui.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.BaseActivity;
import com.lezhi.wshi.module.base.SwipeBackActivity;
import com.lezhi.wshi.utils.JumpUtil;

import butterknife.ButterKnife;

public class RegisterActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        unbinder = ButterKnife.bind(this);
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
