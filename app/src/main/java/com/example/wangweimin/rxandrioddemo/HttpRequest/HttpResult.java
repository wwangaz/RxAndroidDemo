package com.example.wangweimin.rxandrioddemo.HttpRequest;

/**
 * Created by wangweimin on 16/4/5.
 */
public class HttpResult<T> {
    private int resultCode;
    private String resultMessage;

    private T data;

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public T getData() {
        return data;
    }
}
