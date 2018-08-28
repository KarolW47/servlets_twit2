package com.sda.twit2;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void shouldCreateMessage() {
        //given
        MessageCreator messageCreator = new MessageCreator();
        String content = "";
        String author = "";
        String secret = "";
        //when
        Message message = messageCreator.create(content, author, secret);
        //then
        Assert.assertNotNull(message);
    }

    @Test
    public void shouldNewMessageHaveContent() {
        //given
        MessageCreator messageCreator = new MessageCreator();
        String content = "nasza testowa wiadomosc";
        String author = "ktos";
        String secret = "123";
        //when
        Message message = messageCreator.create(content, author, secret);
        //then
        Assert.assertEquals(content, message.getContent());
    }
}
