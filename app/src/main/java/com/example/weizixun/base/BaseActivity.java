package com.example.weizixun.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter,V extends BaseView> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mPresenter=initMvpPresenter();
        if (mPresenter!=null){
            mPresenter.setmView(initMvpView());
        }

        initView();
        initData();
        initLisenter();
    }

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    private void initLisenter() {

    }

    private void initData() {

    }

    private void initView() {

    }

    protected abstract int getLayoutId();

    public void Toast(String msg){
        Toast.makeText(BaseApp.getApp(), msg, Toast.LENGTH_SHORT).show();
    }
}
