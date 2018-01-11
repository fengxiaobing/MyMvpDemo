package com.bing.mymvpdemo.ui.base;



import android.util.Log;

import com.bing.mymvpdemo.data.AppDataManager;
import com.bing.mymvpdemo.data.DataManager;
import com.bing.mymvpdemo.data.db.AppDbHelper;
import com.bing.mymvpdemo.data.network.AppApiHelper;
import com.bing.mymvpdemo.data.prefs.AppPreferencesHelper;
import com.lzy.okgo.OkGo;

import javax.net.ssl.HttpsURLConnection;


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;

    private V mMvpView;


    public BasePresenter() {
        this.mDataManager = AppDataManager.getInstance(new AppDbHelper(), new AppPreferencesHelper(), new AppApiHelper());
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
        getDataManager().cancleNetwork();
    }

    @Override
    public void handleApiError(String error) {
        if(error.contains("test")){
            getDataManager().setCurrentUserLoggedIn(0);
            getMvpView().openActivityOnTokenExpire();
        }else {
            getMvpView().onError(error);
        }

    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }


    @Override
    public void setUserAsLoggedOut() {
        getDataManager().setAccessToken(null);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
