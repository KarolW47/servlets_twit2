package com.sda.twit2.hibernate;

import com.sda.twit2.hibernate.entity.Message;

public class MessageCreator {

    public Message create(String content, String secret) {
        Message message = new Message(content, secret);
        return message;
    }
}
