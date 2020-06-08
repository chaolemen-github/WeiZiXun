package com.example.weizixun.presenter;

import android.text.TextUtils;

import com.example.weizixun.base.BasePresenter;
import com.example.weizixun.bean.LoginBean;
import com.example.weizixun.model.ILoginCallBack;
import com.example.weizixun.model.LoginModel;


public class LoginPresenter extends BasePresenter implements ILoginPresenter, ILoginCallBack {

    private LoginModel model;

    @Override
    protected void initModel() {
        model = new LoginModel();
        addModel(model);
    }

    @Override
    public void onSuccess(LoginBean msg) {
        mView.onSuccess(msg);
    }

    @Override
    public void onError(String error) {
        mView.onError(error);
    }

    @Override
    public void getData(String user, String pass) {
        if (TextUtils.isEmpty(user)) {
            mView.onError("账号不能为空");
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            mView.onError("密码不能为空");
            return;
        }
        model.getData(user, pass, this);
    }

//    private final LoginModel loginModel;
//    private ILoginView view;
//
//    public LoginPresenter(ILoginView view) {
//        this.view = view;
//        loginModel = new LoginModel();
//    }
//
//    @Override
//    public void getData(String user, String pass) {
//        if (TextUtils.isEmpty(user)) {
//            view.onError("账户不能为空");
//            return;
//        }
//
//        if (TextUtils.isEmpty(pass)) {
//            view.onError("账户不能为空");
//            return;
//        }
//
//        loginModel.getData(user, pass, this);
//    }
//
//    @Override
//    public void onSuccess(LoginBean msg) {
//        view.onSuccess("登录成功");
//    }
//
//    @Override
//    public void onError(String error) {
//        view.onError(error);
//    }
}
