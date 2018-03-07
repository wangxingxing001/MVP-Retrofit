package com.lezhi.wshi.module.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.BaseFragment;
import com.lezhi.wshi.module.entity.Prodata;
import com.lezhi.wshi.module.ui.activitys.NewsDetailsActivity;
import com.lezhi.wshi.module.ui.adapter.NewsAdapter;
import com.lezhi.wshi.module.ui.adapter.RecycleItemClickListener;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.ImageHelper;
import com.lezhi.wshi.utils.JumpUtil;
import com.lezhi.wshi.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by ${二星} on 2017/4/27 0027.
 */

public class NewsFragment extends BaseFragment implements BGABanner.OnItemClickListener, BGABanner.Adapter {


    @BindView(R.id.banner_main_default)
    BGABanner bannerMainDefault;
    @BindView(R.id.news_rv)
    RecyclerView newsRv;

    NewsAdapter newsAdapter = null;
    List<Prodata> mList = null;

    int isShowBAGbanner = 0;
    @BindView(R.id.news_header)
    RecyclerViewHeader newsHeader;
    @BindView(R.id.news_scrollview)
    LinearLayout newsScrollview;
    // 获取到没个的 position
    private static final String POSITION_ARGS = "position";
    // Fragment 单列
    public static NewsFragment getInstance(int position) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION_ARGS, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_news;
    }

    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        isShowBAGbanner = getArguments().getInt("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        if (isShowBAGbanner != 0)
            bannerMainDefault.setVisibility(View.GONE);
        else
            bannerMainDefault.setVisibility(View.VISIBLE);
        return rootView;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        super.initView(inflater);
        List<String> imgs = new ArrayList<>();
        List<String> tips = new ArrayList<>();
        // imgs
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493897579318&di=195a5e771bd671e5f868b87d00526db1&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fw7%2F98%2Fd%2F23.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494492321&di=e51fc55804b2eed4ef60d98838179022&imgtype=jpg&er=1&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fa%2F53589b7cb26e7.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493897614501&di=57d0e60da61dc7dc8b0909e7263c0aa7&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537ea15ed93fa.jpg");
        // tips
        tips.add("大理");
        tips.add("马尔代夫");
        tips.add("香格里拉");
        bannerMainDefault.setData(imgs, tips);
        bannerMainDefault.setAdapter(this);
        bannerMainDefault.setOnItemClickListener(this);
        initData();
    }

    private void initData() {
        init();
        RecycleItemClickListener clickListener = new RecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                JumpUtil.jump(getContext(), NewsDetailsActivity.class);
            }
        };
        newsAdapter = new NewsAdapter(mContext, mList, clickListener);
        newsRv.setLayoutManager(new LinearLayoutManager(mContext));
        // 解决滑动不流畅的问题
        newsRv.setNestedScrollingEnabled(false);
        newsRv.setPadding(0, 7, 0, 5);
        SpacesItemDecoration decoration = new SpacesItemDecoration(7, false);
        newsRv.addItemDecoration(decoration);
        newsRv.setItemAnimator(new DefaultItemAnimator());
        newsRv.setAdapter(newsAdapter);
//        newsRv.setFocusable(false);
        newsHeader.attachTo(newsRv);
    }

    private void init() {
        mList = new ArrayList<>();
        mList.add(new Prodata("谁不是一边热爱生活，一边又不想活了呢", "4", "28", "咪蒙", R.mipmap.news_pic01));
        mList.add(new Prodata("生活不止眼前的苟且，还有诗歌远方", "4", "29", "高晓松", R.mipmap.news_pic02));
        mList.add(new Prodata("对啊，因为你  我才爱上这个世界", "5", "10", "咪蒙", R.mipmap.news_pic03));
        mList.add(new Prodata("谁的青春不迷茫", "4", "31", "刘同", R.mipmap.news_pic04));
        mList.add(new Prodata("抱怨身处黑暗，不如提灯前行", "5", "1", "刘同", R.drawable.news_ad_pic01));
        mList.add(new Prodata("房子是租的，但生活是自己的", "5", "2", "卢思浩", R.mipmap.news_pic06));
        mList.add(new Prodata("现代人的崩溃，都是默不作声的", "5", "3", "咪蒙", R.mipmap.news_pic07));
        mList.add(new Prodata("人的一切愤怒都是无能的表现", "5", "4", "xxxx", R.mipmap.news_pic08));
        mList.add(new Prodata("我希望我可以让你改变对这个世界的看法", "5", "9", "咪蒙", R.mipmap.news_pic09));
        mList.add(new Prodata("好看的人很多，有趣的人很少", "5", "6", "xxxx", R.drawable.news_ad_pic02));
        mList.add(new Prodata("你哪有全力以赴  你只是尽力而为", "5", "8", "咪蒙", R.mipmap.news_pic11));
        mList.add(new Prodata("消愁", "5", "8", "巨星不易", R.mipmap.news_pic02));
        mList.add(new Prodata("一杯敬自由", "5", "8", "巨星不易", R.mipmap.news_pic03));
        mList.add(new Prodata("一杯敬死亡", "5", "8", "巨星不易", R.mipmap.news_pic01));
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        ImageHelper.loadImageBannerGlide(getActivity(), (String) model, (ImageView) view);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        EventUtil.showToast(mContext, "" + position);
    }

}
