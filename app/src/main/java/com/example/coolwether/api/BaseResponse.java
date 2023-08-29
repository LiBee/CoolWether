package com.example.coolwether.api;

/**
 * @author 作者: mac
 * @date 日期: 2023/8/18
 * @Description: 响应结果
 */

public class BaseResponse<T> {

  private int status;
  private String message;
  private T data;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }


  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
