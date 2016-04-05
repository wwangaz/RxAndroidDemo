package com.example.wangweimin.rxandrioddemo.subsciber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Created by wangweimin on 16/4/5.
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;

    private Context mContext;
    private boolean mCancelable;
    private ProgressCancelListener mCancelListener;

    public ProgressDialogHandler(Context context, ProgressCancelListener cancelListener, boolean isCancelable) {
        super();
        mContext = context;
        mCancelListener = cancelListener;
        mCancelable = isCancelable;
    }

    private void initProgressDialog() {
        if (pd == null) {
            pd = new ProgressDialog(mContext);

            pd.setCancelable(mCancelable);

            if (mCancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        if (mCancelListener != null)
                            mCancelListener.onCancelProgress();
                    }
                });
            }

            if (!pd.isShowing())
                pd.show();
        }
    }

    private void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
