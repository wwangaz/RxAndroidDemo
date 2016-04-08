package com.example.wangweimin.rxandrioddemo.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wangweimin on 16/4/5.
 */
public class HttpResult<T> {
    @SerializedName("count")
    private int resultCode;

    private String resultMessage;

    @SerializedName("subjects")
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
