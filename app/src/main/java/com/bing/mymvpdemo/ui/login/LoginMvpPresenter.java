package com.bing.mymvpdemo.ui.login;

import com.bing.mymvpdemo.ui.base.MvpPresenter;
import com.bing.mymvpdemo.ui.main.MainMvpView;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onLoginClick();

}
