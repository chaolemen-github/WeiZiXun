package com.example.weizixun.base;

public interface BaseView<T> {
    void onSuccess(T t);
    void onError(String error);
}
