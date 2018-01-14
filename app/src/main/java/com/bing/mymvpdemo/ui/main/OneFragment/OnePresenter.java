

package com.bing.mymvpdemo.ui.main.OneFragment;

import com.bing.mymvpdemo.data.network.callback.NetworkCallback;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.bing.mymvpdemo.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janisharali on 27/01/17.
 */

public class OnePresenter<V extends OneMvpView> extends BasePresenter<V>
        implements OneMvpPresenter<V> {

    public OnePresenter() {
        super();
    }
    int i = 0;
    @Override
    public void onViewPrepared() {
        i++;
        //数据模拟
        List<String> mList = new ArrayList<>();
        if(i % 2 == 1){
            mList.add("http://nres.ingdan.com//uploads/20160113/1452657476755304.jpg");
            mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515911188895&di=4e7a4d964b9845ff9aeb69087048750f&imgtype=0&src=http%3A%2F%2Fi9.hexunimg.cn%2F2015-02-28%2F173605428.jpg");
            mList.add("http://img2.imgtn.bdimg.com/it/u=620183094,2744897300&fm=27&gp=0.jpg");
            mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515911220826&di=e93434614f5a28589a2f8a06f3e2485b&imgtype=0&src=http%3A%2F%2Fpx.thea.cn%2FPublic%2FUpload%2F3836308%2FIntro%2F1490695021.jpg");
        }else {
            mList.add("http://pic23.nipic.com/20120919/8426898_213054250127_2.jpg");
            mList.add("http://img4.imgtn.bdimg.com/it/u=3079979485,2899984191&fm=214&gp=0.jpg");
            mList.add("http://pic23.nipic.com/20120919/8426898_213054250127_2.jpg");
            mList.add("http://img0.imgtn.bdimg.com/it/u=603492941,1132661945&fm=214&gp=0.jpg");
            mList.add("http://pic23.nipic.com/20120919/8426898_213054250127_2.jpg");
        }

        getMvpView().initPagerData(mList);

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
                getMvpView().updateData(null);
                handleApiError(err);
            }
        });
    }

    @Override
    public void onLoadMoreData() {
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
