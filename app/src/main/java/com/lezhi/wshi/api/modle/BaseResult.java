package com.lezhi.wshi.api.modle;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 返回结果基类
 */
public class BaseResult<T> {
    private int code;
    private String msg;
    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
