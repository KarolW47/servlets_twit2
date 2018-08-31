package com.sda.twit2.hibernate.dao;

import com.sda.twit2.hibernate.entity.User;

public class UserDao extends AbstractDao<User> {

    private static UserDao userDao;

    public static UserDao getInstance(){
        if (userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    @Override
    protected Class<User> getClazz() {
        return User.class;
    }
}
