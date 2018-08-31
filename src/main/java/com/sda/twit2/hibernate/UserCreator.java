package com.sda.twit2.hibernate;

import com.sda.twit2.hibernate.entity.User;

public class UserCreator {
    public User create(String login, String password) {
        User user = new User(login, password);
        return user;
    }
}
