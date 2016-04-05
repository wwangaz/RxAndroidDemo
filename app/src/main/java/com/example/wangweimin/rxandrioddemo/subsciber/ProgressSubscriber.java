package com.example.wangweimin.rxandrioddemo.subsciber;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by wangweimin on 16/4/5.
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private ProgressDialogHandler mDialogHandler;

    private Context mContext;

    public ProgressSubscriber(SubscriberOnNextListener<T> subscriberOnNextListener, Context context) {
        mContext = context;
        mSubscriberOnNextListener = subscriberOnNextListener;
        mDialogHandler = new ProgressDialogHandler(mContext, this, true);
    }

    private void showProgressDialog(){
        if(mDialogHandler != null)
            mDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
    }

    private void dismissProgressDialog(){
        if(mDialogHandler != null){
            mDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mDialogHandler = null;
        }
    }


    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
        Toast.makeText(mContext, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }

    @Override
    public void onCancelProgress() {
        if(!this.isUnsubscribed())
            this.unsubscribe();
    }
}
