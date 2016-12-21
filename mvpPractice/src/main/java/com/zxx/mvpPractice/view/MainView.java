package com.zxx.mvpPractice.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Preconditions;
import com.zxx.mvpPractice.R;
import com.zxx.mvpPractice.base.RootView;
import com.zxx.mvpPractice.model.bean.User;
import com.zxx.mvpPractice.presenter.contract.MainContract;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/17
 */

public class MainView extends RootView<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.tv)
    TextView mTextView;
    @BindView(R.id.search_btn)
    Button mButton;
    @BindView(R.id.ed_text)
    EditText mEditText;

    private ProgressDialog dialog;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @OnClick(R.id.search_btn)
    void search(){
        mPresenter.searchUser(mEditText.getText().toString());
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(User userbean) {
        String temp = getResources().getString(R.string.user_format);
        String str = String.format(temp, userbean.getLogin(), userbean.getName(), userbean.getFollowers(), userbean.getFollowing());
        mTextView.setText(str);
    }

    @Override
    public void showErrorMessage(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {
        dialog=new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在搜索中");
    }

    @Override
    protected void initEvent() {

    }
}