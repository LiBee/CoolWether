package com.example.coolwether.api;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @author 作者: mac
 * @date 日期: 2023/8/18
 * @Description: 请求
 */

public class RxNet {
     private static final String TAG = "RxNet";

     public static <T> Disposable request(Observable<BaseResponse> observable, final ResponseCallBack<T> callBack) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Function<Throwable, BaseResponse<T>>() {
                  @Override
                  public BaseResponse<T> apply(Throwable throwable) {
                      callBack.onFailure(ExceptionHandle.handleException(throwable));
                      return null;
                  }
                })
                .subscribe(new Consumer<BaseResponse>() {
                    @Override
                    public void accept(BaseResponse baseResponse) throws Exception {
                        Log.e(TAG, "getStatus: " + baseResponse.getStatus());
                        if (baseResponse.getStatus() == 1) {
                            callBack.onSuccess((T) baseResponse.getData());
                        } else {
                            callBack.onFailure(baseResponse.getMessage());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG,"请求错误:" + throwable.getMessage());
                        callBack.onFailure("服务器错误");
                    }
                });
     }


  /**
   * 返回数据没有body
   */

  public static Disposable requestWithoutBody(Observable<BaseResponse> observable,
                                              final ResponseCallBack<String> callBack) {
    return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn(new Function<Throwable, BaseResponse>() {
              @Override
              public BaseResponse apply(Throwable throwable) {
                callBack.onFailure(ExceptionHandle.handleException(throwable));
                return null;
              }
            })
            .subscribe(new Consumer<BaseResponse>() {
              @Override
              public void accept(BaseResponse baseResponse) {
                Log.d(TAG, "accept: " + baseResponse);
                if (baseResponse.getStatus() == 1) {
                  callBack.onSuccess(baseResponse.getMessage());
                } else {
                  callBack.onFailure(baseResponse.getMessage());
                }
              }
            }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) {
                Log.e(TAG,"请求错误:" + throwable.getMessage());;
              }
            });

  }

  public static Disposable requestNormalHtml(Observable<String> observable, final ResponseCallBack<String> callBack) {
      return observable.subscribeOn(Schedulers.io()) //在I O线程进行网络请求
              .observeOn(AndroidSchedulers.mainThread()) // 回到主线程 处理请求结果
              .onErrorReturn(new Function<Throwable, String >() {
                  @Override
                  public String apply(Throwable throwable) {
                      Log.e(TAG, "apply: " + throwable.getMessage());
                      callBack.onFailure(ExceptionHandle.handleException(throwable));
                      return null;
                  }
              })
              .subscribe(new Consumer<String>() {
                  @Override
                  public void accept(String s) throws Exception {
                      Log.d(TAG, "accept: " + s);
                      callBack.onSuccess(s);
                  }
              }, new Consumer<Throwable>() {
                  @Override
                  public void accept(Throwable throwable) throws Exception {
                      Log.e(TAG,"请求错误:" + throwable.getMessage());;
                  }
              });
  }
}
