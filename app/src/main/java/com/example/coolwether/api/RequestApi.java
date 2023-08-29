package com.example.coolwether.api;



import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author 作者: mac
 * @date 日期: 2023/8/18
 * @Description: 接口类
 */

public interface RequestApi {
  // RxJava 方式 Observale<..>接口形式
  @GET("/")
  Observable<String> getNormalRequest();

}
