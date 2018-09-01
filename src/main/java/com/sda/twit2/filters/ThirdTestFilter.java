package com.sda.twit2.filters;

import com.sda.twit2.AuthenticationHolder_2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ThirdTestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        if (AuthenticationHolder_2.isAuth()) {
            String authenticatedUser = request.getParameter("login");
            session.setAttribute("name", authenticatedUser);
        }

        if (session.getAttribute("name") != null) {
            System.out.println("user authenticated"); //ToDo przerobic!
        } else {
            System.out.println("user not authenticated"); //ToDo przerobic!
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
