package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.contract.NewsDetailsContract;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.Preconditions;

public class NewsDetailsView extends RootView<NewsDetailsContract.Presenter> implements NewsDetailsContract.View {

    public NewsDetailsView(Context context) {
        super(context);
    }

    public NewsDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_news_details_view, this);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(NewsDetailsContract.Presenter presenter) {
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
