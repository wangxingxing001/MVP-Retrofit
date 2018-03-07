package com.lezhi.wshi.api.exception;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 与服务器约定好的异常状态
 */
public class Error {
    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    public static final int NETWORD_ERROR = 1002;
    /**
     * 协议出错
     */
    public static final int HTTP_ERROR = 1003;
}
