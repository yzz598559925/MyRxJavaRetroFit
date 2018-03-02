package com.example.yzz.rxjavaretrofit.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by yzz on 2017/6/23 0023.
 */
public class CallBack<T> implements Observer<T> {
    private Context mContext;

    public CallBack(Context mContext, boolean showProgress) {
        this.mContext = mContext;
        if (showProgress) {
            //显示请求数据的loading
        }
    }

    public void onSuccess(T t) {
        if (null != t) {

        }
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        Log.i("yzz", "onSubscribe");
    }

    @Override
    public void onNext(@NonNull T t) {
        Log.i("yzz", "onNext");
        onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable ex) {
        Log.i("yzz", "onError");
        if (ex instanceof Exception) {
            Exception e = (Exception) ex;
            if (e instanceof UnknownHostException) {
//                ToastUtil.showToast("网络环境不佳，请稍后再试");
            } else if (e instanceof SSLHandshakeException) {
                // 握手失败  访问网络受限
//                ToastUtil.showToast("网络连接失败");
            } else if (e instanceof SocketTimeoutException) {
                // 网络访问超时
//                ToastUtil.showToast("网络访问超时");
            } else if (e instanceof HttpException) {
                // 其他网络访问异常
//                ToastUtil.showToast("网络访问异常");
            } else if (e instanceof ConnectException) {
//                ToastUtil.showToast("网络连接失败");
            } else {
//                ToastUtil.showToast("网络连接失败");
            }

        } else {
//            ToastUtil.showToast("网络环境不佳，请稍后再试");
        }
        if (ex != null) {
            Log.e("net_excption==>", ex.getMessage());
            ex.printStackTrace();
        }
        Toast.makeText(mContext, "网络异常，请稍后再试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        Log.i("yzz", "onComplete");
    }


}
