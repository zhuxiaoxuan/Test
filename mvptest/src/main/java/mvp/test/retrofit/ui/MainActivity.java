package mvp.test.retrofit.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.test.R;
import mvp.test.retrofit.bean.User;
import mvp.test.retrofit.mvp.presenter.MainPresenter;
import mvp.test.retrofit.mvp.view.BaseView;

public class MainActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.tv)
    TextView mTextView;
    @BindView(R.id.search_btn)
    Button mButton;
    @BindView(R.id.ed_text)
    EditText mEditText;

    private  ProgressDialog dialog;
    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        mMainPresenter=new MainPresenter();
        mMainPresenter.attachView(this);
    }

    /**
     * 一些初始化，这里为ProgressDialog的初始化
     */
    private void initView() {
        dialog=new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在搜索中");
    }

    @OnClick(R.id.search_btn)
    void search(View view){
        mMainPresenter.searchUser(mEditText.getText().toString());
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(User userbean) {
        String temp=getResources().getString(R.string.user_format);
        String str=String.format(temp,userbean.getLogin(),userbean.getName(),userbean.getFollowers(),userbean.getFollowing());
        mTextView.setText(str);
    }

    @Override
    public void showErrorMessage(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mMainPresenter!=null)
        mMainPresenter.detachView();
    }
}
