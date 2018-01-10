

package com.bing.mymvpdemo.ui.main.ThreeFragment;


import com.bing.mymvpdemo.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by janisharali on 28/01/17.
 */


public interface ThreeMvpPresenter<V extends ThreeMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
    void QueryData();
}
