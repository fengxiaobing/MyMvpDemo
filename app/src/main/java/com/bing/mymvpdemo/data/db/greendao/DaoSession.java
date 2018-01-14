package com.bing.mymvpdemo.data.db.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bing.mymvpdemo.data.db.entity.User;
import com.bing.mymvpdemo.data.db.entity.Person;
import com.bing.mymvpdemo.data.db.entity.test;

import com.bing.mymvpdemo.data.db.greendao.UserDao;
import com.bing.mymvpdemo.data.db.greendao.PersonDao;
import com.bing.mymvpdemo.data.db.greendao.testDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig personDaoConfig;
    private final DaoConfig testDaoConfig;

    private final UserDao userDao;
    private final PersonDao personDao;
    private final testDao testDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        testDaoConfig = daoConfigMap.get(testDao.class).clone();
        testDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        personDao = new PersonDao(personDaoConfig, this);
        testDao = new testDao(testDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Person.class, personDao);
        registerDao(test.class, testDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        personDaoConfig.getIdentityScope().clear();
        testDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public testDao getTestDao() {
        return testDao;
    }

}
