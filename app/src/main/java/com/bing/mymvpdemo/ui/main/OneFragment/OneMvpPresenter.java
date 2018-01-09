

package com.bing.mymvpdemo.ui.main.OneFragment;


import com.bing.mymvpdemo.ui.base.MvpPresenter;

/**
 * Created by janisharali on 28/01/17.
 */


public interface OneMvpPresenter<V extends OneMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
    void onLoadMoreData();
}
