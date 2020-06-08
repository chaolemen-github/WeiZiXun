package com.example.weizixun.model;


import com.example.weizixun.api.ApiService;
import com.example.weizixun.base.BaseModel;
import com.example.weizixun.base.BaseObservable;
import com.example.weizixun.bean.LoginBean;
import com.example.weizixun.utils.HttpUtils;
import com.example.weizixun.utils.RxUtils;

public class LoginModel extends BaseModel implements ILoginModel {
    @Override
    public void getData(String user, String pass, final ILoginCallBack iLoginCallBack) {

        HttpUtils.getHttpUtils().getApiService(ApiService.login_url,ApiService.class)
                .getLogin(user,pass)
                .compose(RxUtils.<LoginBean>rxObservableTransFormer())
                .subscribe(new BaseObservable<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {

                        if (loginBean.getErrorCode() == 0) {
                            iLoginCallBack.onSuccess(loginBean);
                        } else {
                            iLoginCallBack.onError("登录失败");
                        }
                    }

                    @Override
                    public void onErrors(String error) {
                        iLoginCallBack.onError(error);

                    }
                });


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiService.login_url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        ApiService apiService = retrofit.create(ApiService.class);
//        apiService.getLogin(user, pass)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(LoginBean loginBean) {
//                        if (loginBean.getErrorCode() == 0) {
//                            iLoginCallBack.onSuccess("登录成功");
//                        } else {
//                            iLoginCallBack.onError("登录失败");
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        iLoginCallBack.onError("登录失败" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
