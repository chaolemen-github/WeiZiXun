package com.example.weizixun.base;

public interface BaseCallBack<T> {
    void onSuccess(T t);
    void onError(String error);
}
