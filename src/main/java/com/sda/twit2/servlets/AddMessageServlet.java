package com.sda.twit2.servlets;

import com.sda.twit2.AuthenticationHolder;
import com.sda.twit2.hibernate.dao.MessageDao;
import com.sda.twit2.hibernate.entity.Message;
import com.sda.twit2.hibernate.MessageCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(value = "/message")
public class AddMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageCreator messageCreator = new MessageCreator();
        Message message = messageCreator.create(req.getParameter("content"), req
                .getParameter("secret"));

        if (AuthenticationHolder.isAuth()) {
            MessageDao.getInstance().add(message);
            req.getRequestDispatcher("showMessage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("wrongSecretPass.jsp").forward(req, resp);
        }
    }
}
