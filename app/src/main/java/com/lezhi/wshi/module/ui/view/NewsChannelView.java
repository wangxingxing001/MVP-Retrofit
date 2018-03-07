package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.contract.NewsChannelContract;
import com.lezhi.wshi.module.ui.activitys.NewsChannelActivity;
import com.lezhi.wshi.module.ui.adapter.RecycleItemClickListener;
import com.lezhi.wshi.module.ui.adapter.channerl.ChannelAdapter;
import com.lezhi.wshi.module.ui.adapter.channerl.ChannelHotAdapter;
import com.lezhi.wshi.module.ui.adapter.channerl.ChannelMoreAdapter;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.JumpUtil;
import com.lezhi.wshi.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${二星} on 2017/4/26 0026.
 * 频道管理
 * 删除/增加
 * 3个rv公用一个adapter 创建了3次 如何删除点击的时候 更新不同的adapter
 */

public class NewsChannelView extends RootView<NewsChannelContract.Presenter> implements NewsChannelContract.View {


    @BindView(R.id.indicator_back)
    TextView indicatorBack;
    @BindView(R.id.indicator_title)
    TextView indicatorTitle;
    @BindView(R.id.indicator_ok)
    TextView indicatorOk;
    @BindView(R.id.news_channel_mine_rv)
    RecyclerView newsChannelMineRv;
    @BindView(R.id.news_channel_more_rv)
    RecyclerView newsChannelMoreRv;
    @BindView(R.id.news_channel_hot_rv)
    RecyclerView newsChannelHotRv;

    ChannelAdapter channelAdapterMine;
    ChannelMoreAdapter channelAdapterMore;
    ChannelHotAdapter channelAdapterHot;



    public NewsChannelView(Context context) {
        super(context);
    }

    public NewsChannelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_news_channel_view, this);
    }

    @Override
    protected void initView() {
        indicatorTitle.setText("搜索");
        List<String> list = new ArrayList<>();
        list.add("热门");
        list.add("新高考改革");
        list.add("新高考改革");
        list.add("新高考改革");
        list.add("新高考改革");
        list.add("新高考改革");
        List<String> More_list = new ArrayList<>();
        More_list.add("语文");
        More_list.add("数学");
        More_list.add("政治");
        More_list.add("英语");
        More_list.add("物理");
        More_list.add("化学");
        More_list.add("生物");
        More_list.add("历史");
        More_list.add("综合");
        List<String> Hot_list = new ArrayList<>();
        Hot_list.add("教学政策");
        Hot_list.add("教学理论");
        // 我的频道
        channelAdapterMine = new ChannelAdapter(mContext, list);
        newsChannelMineRv.setLayoutManager(new GridLayoutManager(mContext, 3));
        newsChannelMineRv.setAdapter(channelAdapterMine);
        // 学科
        channelAdapterMore = new ChannelMoreAdapter(mContext, More_list);
        newsChannelMoreRv.setLayoutManager(new GridLayoutManager(mContext, 3));
        newsChannelMoreRv.setAdapter(channelAdapterMore);
        // 热门
        channelAdapterHot = new ChannelHotAdapter(mContext, Hot_list);
        newsChannelHotRv.setLayoutManager(new GridLayoutManager(mContext, 3));
        newsChannelHotRv.setAdapter(channelAdapterHot);
        channelAdapterMine.setPingCallBack(new ChannelAdapter.PingCallBack() {
            @Override
            public void ClickBack(int position) {
                EventUtil.showToast(mContext," A "+position);
            }
        });
        channelAdapterMore.setPingCallBack(new ChannelMoreAdapter.PingCallBack() {
            @Override
            public void ClickBack(int position) {
                EventUtil.showToast(mContext," B "+position);
            }
        });
        channelAdapterHot.setPingCallBack(new ChannelHotAdapter.PingCallBack() {
            @Override
            public void ClickBack(int position) {
                EventUtil.showToast(mContext," C "+position);
            }
        });

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(NewsChannelContract.Presenter presenter) {
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

    @OnClick({R.id.indicator_back, R.id.indicator_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            // 返回上次界面
            case R.id.indicator_back:
                if (mContext instanceof NewsChannelActivity)
                    // 设置override , 不然会使动画失效
                    JumpUtil.overiderAnimsition((NewsChannelActivity) mContext);
                break;
            case R.id.indicator_ok:
                break;
        }
    }

}
