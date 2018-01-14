package com.bing.mymvpdemo.data.db.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bing.mymvpdemo.data.db.greendao.DaoMaster;
import com.bing.mymvpdemo.data.db.greendao.UserDao;

import org.greenrobot.greendao.database.StandardDatabase;

/**
 * Created by Administrator on 2018/1/14.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        DaoMaster.createAllTables(new StandardDatabase(sqLiteDatabase), false);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int currentVersion, int lastestVersion) {
        if(lastestVersion == 5){
            //创建新表
//            Database database = new StandardDatabase(db);
//            PersonDao.createTable(database,true);

            //更新表
            DBMigrationHelper migratorHelper = new DBMigrationHelper();
            migratorHelper.onUpgrade(db, UserDao.class); //这边自己通过版本自行判断需要修改的表
        }

    }
}
