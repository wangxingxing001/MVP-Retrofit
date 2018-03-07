package com.lezhi.wshi.module.base;

/**
 * Author: {王二星}
 * Description: BaseView
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    void showError(String msg);
}
