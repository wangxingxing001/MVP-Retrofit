package com.lezhi.wshi.api.retrofit;


import com.lezhi.wshi.api.exception.ExceptionEngine;
import com.lezhi.wshi.api.exception.ServerException;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.constant.Constant;
import com.lezhi.wshi.module.BaseApplication;
import com.lezhi.wshi.module.entity.HomeEntity;
import com.lezhi.wshi.utils.LogUtil;
import com.lezhi.wshi.utils.NetWorkUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 网络请求初始化
 */
public class HttpMethods {

    private Retrofit retrofit;

    private WeisApi mService;

    private static OkHttpClient okHttpClient;

    private static void initOkHttp() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Constant.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(loggingInterceptor);
            }
            File cacheFile = new File(Constant.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!NetWorkUtil.isNetConnected(BaseApplication.getInstance())) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    int tryCount = 0;
                    Response response = chain.proceed(request);
                    while (!response.isSuccessful() && tryCount < 3) {

                        LogUtil.LogE("RetrofitHelper","interceptRequest is not successful - :{}");
                        tryCount++;

                        // retry the request
                        response = chain.proceed(request);
                    }


                    if (NetWorkUtil.isNetConnected(BaseApplication.getInstance())) {
                        int maxAge = 0;
                        // 有网络时, 不缓存, 最大保存时长为0
                        response.newBuilder()
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .removeHeader("Pragma")
                                .build();
                    } else {
                        // 无网络时，设置超时为4周
                        int maxStale = 60 * 60 * 24 * 28;
                        response.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .removeHeader("Pragma")
                                .build();
                    }
                    return response;
                }
            };
            //设置缓存
            builder.addNetworkInterceptor(cacheInterceptor);
            builder.addInterceptor(cacheInterceptor);
            builder.cache(cache);
            //设置超时
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);
            okHttpClient = builder.build();
        }
    }

    //构造方法私有
    private HttpMethods() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        // 构建完对象传递
        mService = retrofit.create(WeisApi.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance() {
        initOkHttp();
        return SingletonHolder.INSTANCE;
    }

    /**
     * 首页的请求数据
     */
    public Observable<HomeEntity> queryClassification() {
        return mService.getHomePage()
                .map(new ServerResultFunc<HomeEntity>())
                .onErrorResumeNext(new HttpResultFunc<HomeEntity>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static class ServerResultFunc<T> implements Func1<BaseResult<T>, T> {
        @Override
        public T call(BaseResult<T> httpResult) {
            if (httpResult.getCode() != 200) {
                throw new ServerException(httpResult.getCode(), httpResult.getMsg());
            }
            return httpResult.getData();
        }
    }

    public static class HttpResultFunc<T> implements Func1<Throwable, Observable<T>> {
        @Override
        public Observable<T> call(Throwable throwable) {
            return Observable.error(ExceptionEngine.handleException(throwable));
        }
    }
}
