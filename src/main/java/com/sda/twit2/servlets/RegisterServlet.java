package com.sda.twit2.servlets;

import com.sda.twit2.hibernate.UserCreator;
import com.sda.twit2.hibernate.dao.UserDao;
import com.sda.twit2.hibernate.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserCreator userCreator = new UserCreator();
        User user = userCreator.create(req.getParameter("login"),req.getParameter("password"));

        if (req.getParameter("password").equals(req.getParameter("repeatedPassword"))){
            UserDao.getInstance().add(user);
            req.setAttribute("successMessage", "Successfully registered!");
            req.getRequestDispatcher("/loginUser").forward(req,resp);
        }else {
            req.setAttribute("errorMessage","Password does not match!");
            req.getRequestDispatcher("/register").forward(req,resp);
        }
    }
}
