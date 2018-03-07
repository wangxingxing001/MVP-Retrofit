package com.lezhi.wshi.api.exception;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 返回公共类
 */
public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
