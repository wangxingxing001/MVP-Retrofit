package com.lezhi.wshi.module.ui.view;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.MainContract;
import com.lezhi.wshi.module.ui.activitys.MainActivity;
import com.lezhi.wshi.module.ui.adapter.ContentPagerAdapter;
import com.lezhi.wshi.module.ui.fragments.FindFragment;
import com.lezhi.wshi.module.ui.fragments.InformationFragment;
import com.lezhi.wshi.module.ui.fragments.MineFragment;
import com.lezhi.wshi.module.ui.fragments.TeacherSayFragment;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.Preconditions;
import com.lezhi.wshi.widget.UnScrollViewPager;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${二星} on 2017/4/21 0021.
 */

public class MainView extends RootView<MainContract.Presenter> implements MainContract.View, RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.vp_content)
    UnScrollViewPager vpContent;
    @BindView(R.id.tab_rb_1)
    RadioButton tabRb1;
    @BindView(R.id.tab_rb_2)
    RadioButton tabRb2;
    @BindView(R.id.tab_rb_3)
    RadioButton tabRb3;
    @BindView(R.id.tab_rb_4)
    RadioButton tabRb4;
    @BindView(R.id.tab_rg_menu)
    RadioGroup tabRgMenu;
    @BindView(R.id.activity_main_view_relative)
    RelativeLayout activityMainViewRelative;
    MainActivity mActivity;
    ContentPagerAdapter mPagerAdapter;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {
        mActivity = (MainActivity) mContext;
        List<Fragment> fragments = initFragments();
        vpContent.setScrollable(false);
        mPagerAdapter = new ContentPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        vpContent.setAdapter(mPagerAdapter);
        vpContent.setOffscreenPageLimit(fragments.size());
    }

    @Override
    protected void initEvent() {
        tabRgMenu.setOnCheckedChangeListener(this);
        vpContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) tabRgMenu.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.tab_rb_1:
                vpContent.setCurrentItem(0, false);
                break;
            case R.id.tab_rb_2:
                vpContent.setCurrentItem(1, false);
                break;
            case R.id.tab_rb_3:
                vpContent.setCurrentItem(2, false);
                break;
            case R.id.tab_rb_4:
                vpContent.setCurrentItem(3, false);
                break;
        }
    }

    private List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment1 = new InformationFragment();
        Fragment fragment2 = new TeacherSayFragment();
        Fragment fragment3 = new FindFragment();
        Fragment fragment4 = new MineFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        return fragments;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }
}
