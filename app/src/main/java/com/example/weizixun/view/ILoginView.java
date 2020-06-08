package com.example.weizixun.view;


import com.example.weizixun.base.BaseView;
import com.example.weizixun.bean.LoginBean;

public interface ILoginView extends BaseView<LoginBean> {
    void onSuccess(LoginBean loginBean);
    void onError(String error);
}
