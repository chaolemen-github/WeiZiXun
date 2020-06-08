package com.example.weizixun.base;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObservable<T> implements Observer<T> {
    private static final String TAG = "BaseObservable";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: 网络错误：" + e.getMessage());
        onErrors(e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public abstract void onErrors(String error);
}
