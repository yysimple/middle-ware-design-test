package com.simple.middle.test.dbrouter.domain;

/**
* 项目: middle-ware-design-test
*
* 功能描述: controller返回消息体
*
* @author: wuchengxing
* @create: 2022-07-26 23:11:27
**/

public class BaseResponse<T> {
    protected Boolean status = true;
    protected Integer errorCode;
    protected String errorMessage;
    protected T data;

    public BaseResponse() {
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}