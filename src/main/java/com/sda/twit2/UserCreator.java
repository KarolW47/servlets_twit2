package com.sda.twit2;

public class UserCreator {
    public User create(String login, String password){
        User user = new User(login, password);
        return user;
    }
}
