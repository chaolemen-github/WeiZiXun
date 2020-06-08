package com.example.weizixun.model;


import com.example.weizixun.base.BaseCallBack;
import com.example.weizixun.bean.LoginBean;

public interface ILoginCallBack extends BaseCallBack<LoginBean> {
    void onSuccess(LoginBean msg);
    void onError(String error);
}
