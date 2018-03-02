package com.example.yzz.rxjavaretrofit.beans;

import com.example.yzz.rxjavaretrofit.util.GSONUtil;

/**
 * Created by yzz on 2017/6/23
 */
public class BaseBean<T> {
    private String success;
    private String msg;
    private T data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return GSONUtil.toJson(this);
    }
}
