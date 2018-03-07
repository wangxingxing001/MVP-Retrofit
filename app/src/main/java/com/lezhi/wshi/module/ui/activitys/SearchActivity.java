package com.lezhi.wshi.module.ui.activitys;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.base.SwipeBackActivity;
import com.lezhi.wshi.module.ui.view.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends SwipeBackActivity {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.activity_search)
    RelativeLayout activitySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }
}
