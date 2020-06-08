package com.example.weizixun;

import android.widget.Button;
import android.widget.EditText;


import com.example.weizixun.base.BaseActivity;
import com.example.weizixun.bean.LoginBean;
import com.example.weizixun.presenter.LoginPresenter;
import com.example.weizixun.view.ILoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter, ILoginView> implements ILoginView {

    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected ILoginView initMvpView() {
        return this;
    }

    @Override
    protected LoginPresenter initMvpPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast("登录成功");
    }

    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        mPresenter.getData(user,pass);
    }
}
