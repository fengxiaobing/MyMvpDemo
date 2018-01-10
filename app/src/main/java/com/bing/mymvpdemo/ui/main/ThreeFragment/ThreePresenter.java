

package com.bing.mymvpdemo.ui.main.ThreeFragment;

import com.bing.mymvpdemo.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by janisharali on 27/01/17.
 */

public class ThreePresenter<V extends ThreeMvpView> extends BasePresenter<V>
        implements ThreeMvpPresenter<V> {

    public ThreePresenter() {
        super();
    }

    @Override
    public void onViewPrepared() {
        getDataManager().insertUsers("哈哈哈哈");
    }

    @Override
    public void QueryData() {
        List<String> stringList = getDataManager().getAllUsers();
        getMvpView().showDbData(stringList);
    }


}
