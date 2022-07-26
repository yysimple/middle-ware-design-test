package com.simple.middle.test.dbrouter.domain;

/**
* 项目: middle-ware-design-test
*
* 功能描述: controller返回消息体
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:27
**/
public class SimpleResponse<T> extends BaseResponse<T> {
    public SimpleResponse(T data) {
        this.setData(data);
        this.errorCode = 0;
        this.errorMessage = "成功";
    }

    public SimpleResponse() {
        this.errorCode = 0;
        this.errorMessage = "成功";
    }

    public SimpleResponse(Integer code, String msg) {
        this.errorCode = code;
        this.errorMessage = msg;
    }

    public static <T> SimpleResponse<T> error(Integer code, String msg) {
        SimpleResponse<T> response = new SimpleResponse<T>();
        response.returnCode(code);
        response.returnMsg(msg);
        response.setStatus(Boolean.FALSE);
        return response;
    }

    public SimpleResponse<T> returnCode(Integer returnCode) {
        this.errorCode = returnCode;
        return this;
    }

    public SimpleResponse<T> returnMsg(String returnMsg) {
        this.errorMessage = returnMsg;
        return this;
    }
}
