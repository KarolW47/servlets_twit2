package com.sda.twit2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/message")
public class AddMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageCreator messageCreator = new MessageCreator();
        Message message = messageCreator.create(req.getParameter("content"), req.getParameter("author"), req
                .getParameter("secret"));
        req.setAttribute("message", message);


        if (AuthenticationHolder.isAuth()) {
            req.getRequestDispatcher("showMessage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("wrongPass.jsp").forward(req, resp);
        }
    }
}
