package com.sda.twit2;

import com.sda.twit2.hibernate.entity.Message;
import com.sda.twit2.hibernate.MessageCreator;
import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void shouldCreateMessage() {
        //given
        MessageCreator messageCreator = new MessageCreator();
        String content = "";
        String secret = "";
        //when
        Message message = messageCreator.create(content, secret);
        //then
        Assert.assertNotNull(message);
    }

    @Test
    public void shouldNewMessageHaveContent() {
        //given
        MessageCreator messageCreator = new MessageCreator();
        String content = "nasza testowa wiadomosc";
        String secret = "123";
        //when
        Message message = messageCreator.create(content, secret);
        //then
        Assert.assertEquals(content, message.getContent());
    }
}
