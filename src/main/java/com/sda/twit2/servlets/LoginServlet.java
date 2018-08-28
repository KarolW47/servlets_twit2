package com.sda.twit2.servlets;

import com.sda.twit2.AuthenticationHolder_2;
import com.sda.twit2.model.User;
import com.sda.twit2.model.UserCreator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCreator userCreator = new UserCreator();
        User user = userCreator.create(req.getParameter("login"), req.getParameter("password"));
        req.setAttribute("loginUser", user);

        if (AuthenticationHolder_2.isAuth()){
            req.getRequestDispatcher("sendMessage.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("wrongLoginOrPass.jsp").forward(req, resp);
        }
    }
}
