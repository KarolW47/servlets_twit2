package com.sda.twit2;

import com.sda.twit2.model.User;
import com.sda.twit2.model.UserCreator;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void shouldCreateUser() {
        //given
        UserCreator userCreator = new UserCreator();
        String login = "";
        String password = "";
        //when
        User user = userCreator.create(login, password);
        //then
        Assert.assertNotNull(user);
    }

    @Test
    public void shouldNewUserHaveLogin (){
        //given
        UserCreator userCreator = new UserCreator();
        String login = "Ktos";
        String password = "qwerty";
        //when
        User user = userCreator.create(login, password);
        //then
        Assert.assertEquals(login, user.getLogin());
    }
}
