

package com.bing.mymvpdemo.ui.main.ThreeFragment;

import com.bing.mymvpdemo.data.db.entity.User;
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
        User user = new User.Builder()
                .setSex("男")
                .setName("小明")
                .builder();
        getDataManager().insertUsers(user);
    }

    @Override
    public void QueryData() {
        List<User> stringList = getDataManager().getAllUsers();
        getMvpView().showDbData(stringList);
    }


}
