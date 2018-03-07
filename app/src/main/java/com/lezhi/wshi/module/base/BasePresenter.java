package com.lezhi.wshi.module.base;

/**
 * Author: {王二星}
 * Description: BasePresenter
 */
public interface BasePresenter<T> {

    void attachView(T view);

    void detachView();
}
