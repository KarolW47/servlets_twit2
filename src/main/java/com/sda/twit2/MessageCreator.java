package com.sda.twit2;

public class MessageCreator {

    public Message create(String content, String author) {
        Message message = new Message(content, author);
        return message;
    }
}
