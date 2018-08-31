package com.sda.twit2.filters;

import com.sda.twit2.AuthenticationHolder_2;
import com.sda.twit2.hibernate.dao.UserDao;
import com.sda.twit2.hibernate.entity.User;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

public class SecondTestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        AuthenticationHolder_2.setAuth(false);

        List<User> userList = UserDao.getInstance().getAll();

        String loginParam = "";
        String passwordParam = "";

        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            Object currentParam = names.nextElement();
            if (currentParam.equals("login")) {
                loginParam = request.getParameter("login");
            }
            if (currentParam.equals("password")) {
                passwordParam = request.getParameter("password");
            }
        }

        if (loginParam != null && passwordParam != null) {

            String finalLoginParam = loginParam;
            String finalPasswordParam = passwordParam;

            Optional<User> loggedUser = userList.stream()
                    .filter(user -> user.getLogin().equals(finalLoginParam) && user.getPassword().equals(finalPasswordParam))
                    .findFirst();

            if (loggedUser.isPresent()) {
                AuthenticationHolder_2.setAuth(true);

            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}