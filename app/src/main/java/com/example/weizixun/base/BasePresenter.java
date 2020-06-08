package com.example.weizixun.base;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;
    private List<BaseModel> models = new ArrayList<>();

    public void setmView(V mView) {
        this.mView = mView;
    }

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel model){
        models.add(model);
    }

    public void onDestroy(){
        mView=null;
        if (models.size()>0){
            for (BaseModel model : models) {
                model.onDestroy();
            }
            models.clear();
        }
    }
}
