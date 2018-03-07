package com.lezhi.wshi.module.persenter.contract;

import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.BasePresenter;
import com.lezhi.wshi.module.base.BaseView;

/**
 * Created by ${二星} on 2017/4/21 0021.
 */

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showContent(BaseResult videoRes);

        void refreshFaild(String msg);
    }

    interface Presenter extends BasePresenter {
        void onRefresh();
    }
}
