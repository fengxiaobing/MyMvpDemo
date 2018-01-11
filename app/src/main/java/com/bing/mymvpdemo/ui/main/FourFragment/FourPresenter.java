

package com.bing.mymvpdemo.ui.main.FourFragment;

import com.bing.mymvpdemo.data.network.callback.NetworkCallback;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by janisharali on 27/01/17.
 */

public class FourPresenter<V extends FourMvpView> extends BasePresenter<V>
        implements FourMvpPresenter<V> {

    public FourPresenter() {
        super();
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getDataManager().getWhetherApiCall(new NetworkCallback<List<Whether>>() {
            @Override
            public void onSuccess(List<Whether> success) {
                getMvpView().hideLoading();
                getMvpView().showMessage(success.get(0).getCode());
            }

            @Override
            public void onFail(String err) {
                getMvpView().hideLoading();
                handleApiError("第四个错误");
            }
        });
    }
}
