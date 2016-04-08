package com.example.wangweimin.rxandrioddemo.service;

import com.example.wangweimin.rxandrioddemo.entity.Subject;
import com.example.wangweimin.rxandrioddemo.http.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wangweimin on 16/4/1.
 */
public interface MovieService {
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
