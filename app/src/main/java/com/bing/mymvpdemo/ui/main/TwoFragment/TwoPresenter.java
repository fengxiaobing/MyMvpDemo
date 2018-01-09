

package com.bing.mymvpdemo.ui.main.TwoFragment;

import com.bing.mymvpdemo.ui.base.BasePresenter;

/**
 * Created by janisharali on 27/01/17.
 */

public class TwoPresenter<V extends TwoMvpView> extends BasePresenter<V>
        implements TwoMvpPresenter<V> {

    public TwoPresenter() {
        super();
    }

    @Override
    public void onViewPrepared() {

    }

    @Override
    public void onDialogShowClick() {
        getMvpView().showTestDialog();
    }
}
