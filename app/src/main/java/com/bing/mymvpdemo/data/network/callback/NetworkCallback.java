package com.bing.mymvpdemo.data.network.callback;

/**
 * Created by RF
 * on 2018/1/9.
 */

public interface NetworkCallback<T> {
    void onSuccess(T success);
    void onFail(String err);
}
