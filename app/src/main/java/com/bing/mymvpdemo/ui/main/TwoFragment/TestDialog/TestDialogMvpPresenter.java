

package com.bing.mymvpdemo.ui.main.TwoFragment.TestDialog;


import com.bing.mymvpdemo.ui.base.MvpPresenter;


public interface TestDialogMvpPresenter<V extends TestDialogMvpView> extends MvpPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}
