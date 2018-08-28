package com.sda.twit2.model;

public class Message {
    private String content;
    private String author;
    private String secret;

    public Message(String content, String author, String secret) {
        this.content = content;
        this.author = author;
        this.secret = secret;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
