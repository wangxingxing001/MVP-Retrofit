package com.lezhi.wshi.module.persenter;

import com.lezhi.wshi.module.base.BasePresenter;
import com.lezhi.wshi.module.base.BaseView;

/**
 * Description: MainContract
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
    }
}
