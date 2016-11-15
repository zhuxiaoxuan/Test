package com.zxx.simplemvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zxx.simplemvp.R;
import com.zxx.simplemvp.bean.User;
import com.zxx.simplemvp.presenter.UserLoginPresenter;
import com.zxx.simplemvp.view.IUserLoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */
public class LoginActivity extends Activity implements IUserLoginView {

    @Bind(R.id.id_et_username)
    EditText mEtUsername;

    @Bind(R.id.id_et_password)
    EditText mEtPassword;

    @Bind(R.id.id_btn_login)
    Button mBtnLogin;

    @Bind(R.id.id_btn_clear)
    Button mBtnClear;

    @Bind(R.id.id_pb_loading)
    ProgressBar mPbLoading;
    UserLoginPresenter mUserLoginPresenter;

    @Bind(R.id.hello_word)
    Button hello_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mUserLoginPresenter = new UserLoginPresenter(this);
    }

    @OnClick(R.id.id_btn_login)
    public void login(View view) {
        mUserLoginPresenter.login();
    }

    @OnClick(R.id.id_btn_clear)
    public void clear(View view) {
        mUserLoginPresenter.clear();
    }

    @OnClick(R.id.hello_word)
    public void helloword(View view) {
        mUserLoginPresenter.sayHelloWord();
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFaileError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sayHelloWord() {
        Toast.makeText(this,
                "helloword", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
