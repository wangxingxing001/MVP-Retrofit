package com.lezhi.wshi.module.ui.fragments;

import android.view.LayoutInflater;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.BaseFragment;
import com.lezhi.wshi.module.persenter.FindPresenter;

/**
 * Created by ${二星} on 2017/4/21 0021.
 */

public class FindFragment extends BaseFragment{

    // 指定FramgnetView布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
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
//        ((FindPresenter)mPresenter).onRefresh();
    }
}
