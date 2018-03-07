package com.lezhi.wshi.api.exception;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 异常信息公共类
 */
public class ApiException extends Exception {


    private int code;
    private String displayMessage;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
