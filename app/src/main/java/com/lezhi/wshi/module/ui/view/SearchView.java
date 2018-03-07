package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.entity.UserSearchCache;
import com.lezhi.wshi.module.BaseApplication;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.contract.SearchContract;
import com.lezhi.wshi.module.ui.activitys.SearchActivity;
import com.lezhi.wshi.module.ui.adapter.channerl.ChannelAdapter;
import com.lezhi.wshi.utils.CheckNull;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${二星} on 2017/4/26 0026.
 * 搜索界面
 * 1.进来请求网络数据,显示热门标签
 * 2.搜索框进行搜索,隐藏之前布局
 * 3.不搜索时候,再次展示布局
 */

public class SearchView extends RootView<SearchContract.Presenter> implements SearchContract.View {


    ChannelAdapter channelAdapterMine;
    @BindView(R.id.search_key)
    EditText searchKey;
    @BindView(R.id.search_iv_del)
    ImageView searchIvDel;
    @BindView(R.id.search_titlebar)
    LinearLayout searchTitlebar;
    @BindView(R.id.search_tv_del_db)
    TextView searchTvDelDb;
    @BindView(R.id.search_titlebar_title)
    RelativeLayout searchTitlebarTitle;
    @BindView(R.id.search_hot_rv)
    RecyclerView searchHotRv;
    @BindView(R.id.search_hot_history)
    RecyclerView searchHotHistory;
    @BindView(R.id.activity_search)
    LinearLayout activitySearch;


    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_search_view, this);
    }

    @Override
    protected void initView() {
        // 监听Edtext的操作
        initEdText();
        // 从数据库中拿数据，然后依次展示在列表中
        initData();
    }


    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
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

    // 查询数据库
    private List<String> initGetDBData() {
        List<String> mListData = new ArrayList<>();
        if (CheckNull.getBody(BaseApplication.getDBHelper().getUserSearchMsgCacheList())) {
            // 不等于null  说明有数据,拿到存放到List中  返回
            for (int i = 0; i < BaseApplication.getDBHelper().getUserSearchMsgCacheList().size(); i++) {
                mListData.add(BaseApplication.getDBHelper().getUserSearchMsgCacheList().get(i).getSearchKey());
            }
            return mListData;
        }
        return null;
    }

    // 监听Edtext输入框
    private void initEdText() {
        searchKey.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    EventUtil.showToast(mContext, "Clike me ?");
                    // 进行请求数据，然后保存到数据库
                    if (CheckNull.getBody(searchKey)) {
                        UserSearchCache searchCache = new UserSearchCache();
                        searchCache.setSearchKey("" + searchKey.getText().toString());
                        // 把拿到的关键字,存到本地的数据库
                        BaseApplication.getDBHelper().saveUserSearchCache(searchCache);
                        // 看需求 是跳转，还是在本界面
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void initData() {
//        List<String> mListData = initGetDBData();
        List<String> mListData = new ArrayList<>();
        mListData.add("高考");
        mListData.add("高考");
        mListData.add("高考");
        mListData.add("高考");
        mListData.add("高考");
        List<String> mListDefulData = new ArrayList<>();
        mListDefulData.add("高考");
        mListDefulData.add("新高考改革");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");
        mListDefulData.add("最新政策");

        channelAdapterMine = new ChannelAdapter(mContext, mListData);
        searchHotHistory.setLayoutManager(new LinearLayoutManager(mContext));
        searchHotHistory.setAdapter(channelAdapterMine);

        channelAdapterMine = new ChannelAdapter(mContext, mListDefulData);
        searchHotRv.setLayoutManager(new GridLayoutManager(mContext, 3));
        searchHotRv.setAdapter(channelAdapterMine);
    }

    @OnClick({R.id.search_iv_del, R.id.search_tv_del_db})
    public void onClick(View view) {
        switch (view.getId()) {
            // 关闭界面 , 关闭软键盘
            case R.id.search_iv_del:
                searchKey.clearFocus();
                ((SearchActivity) mContext).finish();
                break;
            // 清空数据库数据
            case R.id.search_tv_del_db:
                BaseApplication.getDBHelper().ClearUserBye();
                initData();
                break;
        }
    }

}
