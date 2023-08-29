package com.example.coolwether.api;

/**
 * @author 作者: mac
 * @date 日期: 2023/8/18
 * @Description: 响应回调
 */

public interface ResponseCallBack<T> {
  /**
   *  数据请求成功
   * @param data
   */
    void onSuccess(T data);

  /**
   * 数据请求失败
   * @param msg
   */
  void onFailure(String msg);
}
