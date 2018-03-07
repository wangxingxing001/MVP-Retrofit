package com.lezhi.wshi.module.persenter;

import android.support.annotation.NonNull;

import com.lezhi.wshi.module.base.RxPresenter;
import com.lezhi.wshi.module.persenter.contract.InformationContract;
import com.lezhi.wshi.module.persenter.contract.TeacherContract;
import com.lezhi.wshi.utils.Preconditions;

/**
 * Created by ${二星} on 2017/4/21 0021.
 */

public class TeacherPresenter extends RxPresenter implements TeacherContract.Presenter {
    // 构造接口View实现类
    TeacherContract.View mView;


    public TeacherPresenter(@NonNull TeacherContract.View view){
        mView = Preconditions.checkNotNull(view);
        mView.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        // 构造请求方法
        getData();
    }

    void getData(){
        // 在此调用Retrofit中的构造方法

    }
}
