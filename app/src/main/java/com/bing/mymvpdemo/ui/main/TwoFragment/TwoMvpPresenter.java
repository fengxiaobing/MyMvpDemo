

package com.bing.mymvpdemo.ui.main.TwoFragment;


import com.bing.mymvpdemo.ui.base.MvpPresenter;

/**
 * Created by janisharali on 28/01/17.
 */


public interface TwoMvpPresenter<V extends TwoMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
    void onDialogShowClick();
}
