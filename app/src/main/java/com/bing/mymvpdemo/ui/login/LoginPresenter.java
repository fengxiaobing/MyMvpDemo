

package com.bing.mymvpdemo.ui.login;

import android.util.Log;

import com.bing.mymvpdemo.data.DataManager;
import com.bing.mymvpdemo.ui.base.BasePresenter;
import com.bing.mymvpdemo.ui.main.MainMvpPresenter;
import com.bing.mymvpdemo.ui.main.MainMvpView;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    public LoginPresenter() {
        super();
    }
    @Override
    public void onLoginClick() {
        getDataManager().setCurrentUserLoggedIn(1);
        getMvpView().openMainActivity();
    }
}
