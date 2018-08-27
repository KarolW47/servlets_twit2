package com.sda.twit2;

public class MessageCreator {

    public Message create(String content, String author, String secret) {
        Message message = new Message(content, author, secret);
        return message;
    }
}
