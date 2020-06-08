package com.example.weizixun.api;


import com.example.weizixun.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
//    https://www.wanandroid.com/user/login?username=朝乐门&password=123

    String login_url = "https://www.wanandroid.com/";

    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("username") String user, @Field("password") String pass);
}
