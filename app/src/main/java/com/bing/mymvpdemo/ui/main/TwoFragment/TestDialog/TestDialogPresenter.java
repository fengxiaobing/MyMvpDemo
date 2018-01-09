

package com.bing.mymvpdemo.ui.main.TwoFragment.TestDialog;


import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.ui.base.BasePresenter;

public class TestDialogPresenter<V extends TestDialogMvpView> extends BasePresenter<V>
        implements TestDialogMvpPresenter<V> {

    public static final String TAG = "TestDialogPresenter";

    private boolean isRatingSecondaryActionShown = false;



    @Override
    public void onRatingSubmitted(final float rating, String message) {

        if (rating == 0) {
            getMvpView().showMessage("请选择分级");
            return;
        }

        if (!isRatingSecondaryActionShown) {
            if (rating == 5) {
                getMvpView().showPlayStoreRatingView();
                getMvpView().hideSubmitButton();
                getMvpView().disableRatingStars();
            } else {
                getMvpView().showRatingMessageView();
            }
            isRatingSecondaryActionShown = true;
            return;
        }

        getMvpView().showLoading();
        getMvpView().showMessage("上传到后台");
        //for demo
        getMvpView().hideLoading();

        getMvpView().dismissDialog();

    }

    private void sendRatingDataToServerInBackground(float rating) {

    }

    @Override
    public void onCancelClicked() {
        getMvpView().dismissDialog();
    }

    @Override
    public void onLaterClicked() {
        getMvpView().dismissDialog();
    }

    @Override
    public void onPlayStoreRatingClicked() {
        getMvpView().openPlayStoreForRating();
        sendRatingDataToServerInBackground(5);
        getMvpView().dismissDialog();
    }
}
