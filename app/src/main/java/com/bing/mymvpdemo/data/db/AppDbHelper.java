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

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bing.mymvpdemo.App;
import com.bing.mymvpdemo.data.prefs.PreferencesHelper;
import com.bing.mymvpdemo.utils.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.bing.mymvpdemo.data.db.DbOpenHelper.USER_TABLE_NAME;


public class AppDbHelper implements DbHelper {
    private static DatabaseManager mDatabaseManager = App.mDatabaseManager;

    @Override
    public List<String> getAllUsers() {
        List<String> stringList = new ArrayList<>();
        SQLiteDatabase database = mDatabaseManager.getReadableDatabase();
        Cursor cursor = database.query(DbOpenHelper.USER_TABLE_NAME, null, null, null, null, null, null);
        if (cursor.getColumnCount() > 0 && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                stringList.add(name);
            }
        }
        cursor.close();
        mDatabaseManager.closeDatabase();
        return stringList;
    }

    @Override
    public void insertUsers(String name) {
        SQLiteDatabase database = mDatabaseManager.getWritableDatabase();
//生成ContentValues对象 //key:列名，value:想插入的值
        ContentValues cv = new ContentValues();
//往ContentValues对象存放数据，键-值对模式
        cv.put("name", name);
//调用insert方法，将数据插入数据库
        database.insert(DbOpenHelper.USER_TABLE_NAME, null, cv);
//关闭数据库
        mDatabaseManager.closeDatabase();
    }
}
