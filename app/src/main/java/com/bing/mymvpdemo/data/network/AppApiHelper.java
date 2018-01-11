/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bing.mymvpdemo.data.network;

import com.bing.mymvpdemo.data.db.DbHelper;
import com.bing.mymvpdemo.data.network.callback.InterceptCallback;
import com.bing.mymvpdemo.data.network.callback.NetworkCallback;
import com.bing.mymvpdemo.data.network.model.HttpResult;
import com.bing.mymvpdemo.data.network.model.Whether;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.List;


public class AppApiHelper implements ApiHelper {


    @Override
    public void getWhetherApiCall(final NetworkCallback<List<Whether>> networkCallback) {
        OkGo.<HttpResult<List<Whether>>>get(ApiEndPoint.ENDPOINT_WHATHER)
                .tag(this)
                .execute(new InterceptCallback<HttpResult<List<Whether>>>() {
                    @Override
                    public void onSuccess(Response<HttpResult<List<Whether>>> response) {
                        List<Whether> whetherList = response.body().hourly;
                        networkCallback.onSuccess(whetherList);
                    }

                    @Override
                    public void onError(Response<HttpResult<List<Whether>>> response) {
                        super.onError(response);
                        String err = response.getException().getLocalizedMessage();
                        networkCallback.onFail(err);
                    }
                });

    }

    @Override
    public void cancleNetwork() {
        OkGo.getInstance().cancelTag(this);
    }
}
