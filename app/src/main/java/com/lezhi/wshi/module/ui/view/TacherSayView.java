package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.entity.TecherEntity;
import com.lezhi.wshi.module.persenter.contract.TeacherContract;
import com.lezhi.wshi.module.ui.activitys.SearchActivity;
import com.lezhi.wshi.module.ui.adapter.TecherSayAdapter;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.JumpUtil;
import com.lezhi.wshi.utils.LogUtil;
import com.lezhi.wshi.utils.Preconditions;
import com.lezhi.wshi.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 师说View
 */

public class TacherSayView extends RootView<TeacherContract.Presenter> implements TeacherContract.View {


    @BindView(R.id.tacher_rv)
    RecyclerView tacherRv;

    List<TecherEntity> mList;

    TecherSayAdapter adapter;


    @BindView(R.id.scrollview_view_techer)
    ScrollView scrollviewViewTecher;
    @BindView(R.id.indicator_left)
    ImageView indicatorLeft;
    @BindView(R.id.indicator_title)
    TextView indicatorTitle;

    public TacherSayView(Context context) {
        super(context);
    }

    public TacherSayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_tacher_view, this);
    }

    @Override
    protected void initView() {
        LogUtil.LogE("#","#### TacherView Create");
        indicatorTitle.setText("师说");
        initData();
        adapter = new TecherSayAdapter(mContext, mList);
        tacherRv.setLayoutManager(new LinearLayoutManager(mContext));
        // 解决滑动不流畅的问题
        tacherRv.setNestedScrollingEnabled(false);
        tacherRv.setPadding(0, 7, 0, 5);
        SpacesItemDecoration decoration = new SpacesItemDecoration(7, false);
        tacherRv.addItemDecoration(decoration);
        tacherRv.setItemAnimator(new DefaultItemAnimator());
        tacherRv.setAdapter(adapter);
        tacherRv.setFocusable(false);
    }


    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(TeacherContract.Presenter presenter) {
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

    private void initData() {
        mList = new ArrayList<>();
        mList.add(new TecherEntity("生活不易  且活且珍惜", "xxxx", "教育专家"));
        mList.add(new TecherEntity("我们深知这个世界的黑暗", "咪蒙", "文学家"));
        mList.add(new TecherEntity("但是我们依旧要努力", "咪蒙", "文学家"));
        mList.add(new TecherEntity("不是为了让世界看到，而是为了看到整个世界", "咪蒙", "文学家"));
        mList.add(new TecherEntity("我们都能迷茫", "xxxx", "教育专家"));
        mList.add(new TecherEntity("但至少 青春的日子总让人怀念", "xxxx", "教育专家"));
        mList.add(new TecherEntity("不要固执的以为  有的人一辈子就是那样", "xxxx", "教育专家"));
        mList.add(new TecherEntity("改变一个人的性格真的很难", "xxxx", "教育专家"));
    }

    @OnClick(R.id.indicator_left)
    public void onClick() {
    }

    @OnClick(R.id.indicator_left)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.indicator_left:
                JumpUtil.jump(mContext, SearchActivity.class);
                break;
        }
    }
}
