package com.lezhi.wshi.api.retrofit;

import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.entity.HomeEntity;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: Api接口类
 */
public interface WeisApi {

    /**
     * 首页
     *
     * @return
     */
    @POST("homePageApi/homePage.do")
    Observable<BaseResult<HomeEntity>> getHomePage();
}
