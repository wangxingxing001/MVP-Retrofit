package com.lezhi.wshi.module.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lezhi.wshi.utils.LogUtil;
import org.simple.eventbus.EventBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * Author: {王二星}
 * Description: BaseFragment
 */
public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment {

    private final String TAG = getClass().getSimpleName();
    protected T mPresenter;
    protected Context mContext;
    protected View rootView;
    protected Unbinder unbinder;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据



    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        LogUtil.LogE(TAG,"------>onAttach");
        if (mContext != null) {
            this.mContext = mContext;
        } else {
            this.mContext = getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.LogE(TAG,"------>onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.LogE(TAG,"------>onCreateView");
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        unbinder = ButterKnife.bind(this, rootView);
        initView(inflater);
        EventBus.getDefault().register(this);
        setTitleHeight(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.LogE(TAG,"------>onActivityCreated");
        initEvent();
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.LogE(TAG,"------>onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.LogE(TAG,"------>onResume");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.LogE(TAG,"------>onViewCreated");
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.LogE(TAG,"------>onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.LogE(TAG,"------>onStop");
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
        LogUtil.LogE(TAG,"------>onDestroyView");
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasFetchData = false;
        isViewPrepared = false;
        mPresenter = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.LogE(TAG,"------>onDestroy");
        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.LogE(TAG,"------>onDetach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.v(TAG, getClass().getName() + "------>isVisibleToUser = " + isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }

    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }

    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected void lazyFetchData() {
        Log.v(TAG, getClass().getName() + "------>lazyFetchData");
    }

    public String getName() {
        return BaseFragment.class.getName();
    }

    protected abstract int getLayout();

    protected void initView(LayoutInflater inflater) {
    }

    protected void initEvent() {
    }

//    @Subscriber(tag = MainActivity.Set_Theme_Color)
//    public void setTheme(String arg) {
//        final View rootView = getActivity().getWindow().getDecorView();
//        rootView.setDrawingCacheEnabled(true);
//        rootView.buildDrawingCache(true);
//
//        final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
//        rootView.setDrawingCacheEnabled(false);
//        if (null != localBitmap && rootView instanceof ViewGroup) {
//            final View tmpView = new View(getContext());
//            tmpView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
//            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            ((ViewGroup) rootView).addView(tmpView, params);
//            tmpView.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//                    ColorUiUtil.changeTheme(rootView, getContext().getTheme());
//                    System.gc();
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    ((ViewGroup) rootView).removeView(tmpView);
//                    localBitmap.recycle();
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//
//                }
//            }).start();
//        }
//    }

    private void setTitleHeight(View view) {
//        if (view != null) {
//            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                if (title != null) {
//                    ViewGroup.LayoutParams lp = title.getLayoutParams();
//                    lp.height = ScreenUtil.dip2px(getContext(), 48);
//                    title.setLayoutParams(lp);
//                    title.setPadding(0, 0, 0, 0);
//                }
//                if (TAG.equals(MineFragment.class.getSimpleName())) {
//                    Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//                    ViewGroup.LayoutParams lp = toolbar.getLayoutParams();
//                    lp.height = ScreenUtil.dip2px(getContext(), 48);
//                    toolbar.setLayoutParams(lp);
//                }
//            }
//        }
    }

}
