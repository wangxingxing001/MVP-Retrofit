package com.lezhi.wshi.module.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lezhi.wshi.module.ui.fragments.NewsFragment;

import java.util.List;

/**
 * Created by hackware on 2016/9/10.
 */

public class ExamplePagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mDataList;

    public ExamplePagerAdapter(FragmentManager fm,List<String> mList) {
        super(fm);
        this.mDataList = mList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.getInstance(position);
    }
}
