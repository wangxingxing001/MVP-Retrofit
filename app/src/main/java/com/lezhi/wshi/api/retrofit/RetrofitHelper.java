//package com.lezhi.wshi.api.retrofit;
//
//
//import com.lezhi.wshi.module.entity.HomeEntity;
//
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//
//public class RetrofitHelper {
//
//    private static WeisApi mService;
//
//    public static RetrofitHelper getInstance(){
//        // 初始化网络方法
//        HttpMethods.getInstance();
//        getWeisApis(mService);
//        return new RetrofitHelper();
//    }
//
//
//    // 获取单列
//    private static WeisApi getWeisApis(WeisApi weisApi) {
//        // 拿到对象
//        if (weisApi!=null){
//            mService = weisApi;
//            return mService;
//        }
//        return null;
//    }
//
//    /**
//     * 首页的请求数据
//     */
//    public Observable<HomeEntity> queryClassification() {
//        return mService.getHomePage()
//                .map(new HttpMethods.ServerResultFunc<HomeEntity>())
//                .onErrorResumeNext(new HttpMethods.HttpResultFunc<HomeEntity>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//    /**
//     * 次页的请求数据
//     */
//    private Observable<HomeEntity> queryClassification1() {
//        return mService.getHomePage()
//                .map(new HttpMethods.ServerResultFunc<HomeEntity>())
//                .onErrorResumeNext(new HttpMethods.HttpResultFunc<HomeEntity>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//    /**
//     * 次页的请求数据
//     */
//    private Observable<HomeEntity> queryClassification2() {
//        return mService.getHomePage()
//                .map(new HttpMethods.ServerResultFunc<HomeEntity>())
//                .onErrorResumeNext(new HttpMethods.HttpResultFunc<HomeEntity>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//}
