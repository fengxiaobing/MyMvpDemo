

package com.bing.mymvpdemo.ui.main.OneFragment;

import com.bing.mymvpdemo.data.network.callback.NetworkCallback;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by janisharali on 27/01/17.
 */

public class OnePresenter<V extends OneMvpView> extends BasePresenter<V>
        implements OneMvpPresenter<V> {

    public OnePresenter() {
        super();
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getDataManager().getWhetherApiCall(new NetworkCallback<List<Whether>>() {
            @Override
            public void onSuccess(List<Whether> success) {
                getMvpView().hideLoading();
                getMvpView().updateData(success);
            }

            @Override
            public void onFail(String err) {
                getMvpView().hideLoading();
                handleApiError(err);
            }
        });
    }
}
