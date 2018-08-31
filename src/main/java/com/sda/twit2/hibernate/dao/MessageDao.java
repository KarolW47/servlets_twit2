package com.sda.twit2.hibernate.dao;

import com.sda.twit2.hibernate.entity.Message;

public class MessageDao extends AbstractDao<Message>{

    private static MessageDao messageDao;

    public static MessageDao getInstance(){
        if (messageDao == null){
            messageDao = new MessageDao();
        }
        return messageDao;
    }

    @Override
    protected Class<Message> getClazz() {
        return Message.class;
    }
}
