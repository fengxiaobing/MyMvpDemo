

package com.bing.mymvpdemo.ui.main;

import android.util.Log;

import com.bing.mymvpdemo.R;
import com.bing.mymvpdemo.data.DataManager;
import com.bing.mymvpdemo.ui.base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";
    public MainPresenter() {
        super();
    }


}
