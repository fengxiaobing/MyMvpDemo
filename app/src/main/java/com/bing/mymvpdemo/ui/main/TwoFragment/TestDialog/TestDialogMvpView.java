

package com.bing.mymvpdemo.ui.main.TwoFragment.TestDialog;


import com.bing.mymvpdemo.ui.base.DialogMvpView;

public interface TestDialogMvpView extends DialogMvpView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();
}
