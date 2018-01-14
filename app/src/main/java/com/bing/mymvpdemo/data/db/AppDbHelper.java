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

package com.bing.mymvpdemo.data.db;


import com.bing.mymvpdemo.App;
import com.bing.mymvpdemo.data.db.entity.User;
import com.bing.mymvpdemo.data.db.greendao.DaoSession;
import com.bing.mymvpdemo.data.db.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class AppDbHelper implements DbHelper {

    @Override
    public List<User> getAllUsers() {
        DaoSession session = App.getContext().getDaoSession();
        UserDao mUserDao =  session.getUserDao();
        QueryBuilder<User> qb = mUserDao.queryBuilder();
        List<User> list = qb.list();
        return list;
    }

    @Override
    public void insertUsers(User user) {
        DaoSession session = App.getContext().getDaoSession();
        UserDao mUserDao =  session.getUserDao();
        mUserDao.insertOrReplace(user);
    }
}
