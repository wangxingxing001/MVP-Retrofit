package com.lezhi.wshi.module.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.api.modle.BaseResult;
import com.lezhi.wshi.module.base.RootView;
import com.lezhi.wshi.module.persenter.contract.MineContract;
import com.lezhi.wshi.module.ui.activitys.LoginActivity;
import com.lezhi.wshi.module.ui.activitys.RegisterActivity;
import com.lezhi.wshi.utils.EventUtil;
import com.lezhi.wshi.utils.JumpUtil;
import com.lezhi.wshi.utils.LogUtil;
import com.lezhi.wshi.utils.Preconditions;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author {王二星}
 * 2017/4/26
 */

public class MineView extends RootView<MineContract.Presenter> implements MineContract.View {


    @BindView(R.id.fragment_mine_photo)
    ImageView fragmentMinePhoto;
    @BindView(R.id.fragment_mine_login)
    TextView fragmentMineLogin;
    @BindView(R.id.fragment_mine_register)
    TextView fragmentMineRegister;
    @BindView(R.id.fragment_mine_collection)
    LinearLayout fragmentMineCollection;
    @BindView(R.id.fragment_mine_notice)
    LinearLayout fragmentMineNotice;
    @BindView(R.id.fragment_mine_comment)
    LinearLayout fragmentMineComment;
    @BindView(R.id.fragment_mine_user)
    LinearLayout fragmentMineUser;
    @BindView(R.id.fragment_mine_settings)
    LinearLayout fragmentMineSettings;
    @BindView(R.id.fragment_mine_feedback)
    LinearLayout fragmentMineFeedback;
    @BindView(R.id.activity_main_view_relative)
    LinearLayout activityMainViewRelative;
    @BindView(R.id.fragment_mine_tv_integral)
    TextView fragmentMineTvIntegral;
    @BindView(R.id.fragment_mine_integral)
    LinearLayout fragmentMineIntegral;
    @BindView(R.id.fragment_mine_sign)
    LinearLayout fragmentMineSign;

    public MineView(Context context) {
        super(context);
    }

    public MineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_mine_view, this);
    }

    @Override
    protected void initView() {
        LogUtil.LogE("#","#### MineView Create");
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(BaseResult videoRes) {

    }

    @Override
    public void refreshFaild(String msg) {

    }

    @OnClick({R.id.fragment_mine_login, R.id.fragment_mine_register, R.id.fragment_mine_collection, R.id.fragment_mine_notice, R.id.fragment_mine_comment, R.id.fragment_mine_user, R.id.fragment_mine_settings, R.id.fragment_mine_feedback, R.id.fragment_mine_sign, R.id.fragment_mine_integral})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_mine_login:
                JumpUtil.jump(mContext, LoginActivity.class);
                break;
            case R.id.fragment_mine_register:
                JumpUtil.jump(mContext, RegisterActivity.class);
                break;
            case R.id.fragment_mine_collection:
                break;
            case R.id.fragment_mine_notice:
                break;
            case R.id.fragment_mine_comment:
                break;
            case R.id.fragment_mine_user:
                break;
            case R.id.fragment_mine_settings:
                break;
            case R.id.fragment_mine_feedback:
                break;
            case R.id.fragment_mine_integral:
                break;
            case R.id.fragment_mine_sign:
                break;
        }
    }
}
