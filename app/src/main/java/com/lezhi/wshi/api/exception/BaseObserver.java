package com.lezhi.wshi.api.exception;


import rx.Subscriber;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 任意对象判断为空
 */
public abstract class BaseObserver<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
//        e.printStackTrace();
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, 123));
        }
    }

    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);
}
