package com.example.weizixun.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {

    public CompositeDisposable compositeDisposable;

    public void onDestroy(){
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }

    public void addModel(Disposable disposable){
        if (compositeDisposable==null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

}
