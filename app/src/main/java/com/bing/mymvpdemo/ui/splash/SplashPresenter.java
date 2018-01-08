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

package com.bing.mymvpdemo.ui.splash;


import com.bing.mymvpdemo.data.DataManager;
import com.bing.mymvpdemo.ui.base.BasePresenter;

import java.util.logging.Handler;

/**
 * Created by janisharali on 27/01/17.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {


    public SplashPresenter() {
        super();
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        if (getDataManager().getCurrentUserLoggedIn() == 0) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }
    }
}
