package com.example.wangweimin.rxandrioddemo.subsciber;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by wangweimin on 16/4/5.
 */
public class ProgressSubscriber<T> extends Subscriber<T> {

    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private Context mContext;

    public ProgressSubscriber(SubscriberOnNextListener<T> subscriberOnNextListener, Context context) {
        mContext = context;
        mSubscriberOnNextListener = subscriberOnNextListener;
    }


    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {
        Toast.makeText(mContext, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }
}
