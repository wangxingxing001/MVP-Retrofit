package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.contract.FindContract;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.LogUtil;
import com.lezhi.wshi.utils.Preconditions;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 师说View
 */

public class FindView extends RootView<FindContract.Presenter> implements FindContract.View {


    @BindView(R.id.indicator_left)
    ImageView indicatorLeft;
    @BindView(R.id.indicator_title)
    TextView indicatorTitle;
    @BindView(R.id.activity_main)
    ScrollView activityMain;

    public FindView(Context context) {
        super(context);
    }

    public FindView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_find_view, this);
    }

    @Override
    protected void initView() {
        indicatorLeft.setVisibility(GONE);
        indicatorTitle.setText("发现");
        LogUtil.LogE("#","#### FindView Create");

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(FindContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(BaseResult videoRes) {

    }

    @Override
    public void refreshFaild(String msg) {

    }

}
