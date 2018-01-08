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

package com.bing.mymvpdemo.ui.main;

import android.util.Log;

import com.bing.mymvpdemo.data.DataManager;
import com.bing.mymvpdemo.ui.base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    public MainPresenter() {
        super();
    }

    @Override
    public void onDrawerOptionAboutClick() {
        Log.e("TAG","个哈哈");
    }
}
