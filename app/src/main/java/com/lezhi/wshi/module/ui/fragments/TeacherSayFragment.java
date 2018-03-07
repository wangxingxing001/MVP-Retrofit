package com.lezhi.wshi.module.ui.fragments;

import android.view.LayoutInflater;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.BaseFragment;
import com.lezhi.wshi.module.persenter.TeacherPresenter;
import com.lezhi.wshi.utils.LogUtil;

/**
 * Created by ${二星} on 2017/4/21 0021.
 */

public class TeacherSayFragment extends BaseFragment {

    // 指定FramgnetView布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_tacher;
    }
    // 初始化View , presenter等
    @Override
    protected void initView(LayoutInflater inflater) {
        super.initView(inflater);
    }
    // 懒加载
    @Override
    protected void lazyFetchData() {
        super.lazyFetchData();
//        ((TeacherPresenter)mPresenter).onRefresh();
        LogUtil.LogE("#","### TeacherSayFragment loading data");
    }
}
