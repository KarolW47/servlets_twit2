package com.sda.twit2.filters;

import com.sda.twit2.AuthenticationHolder_2;
import com.sda.twit2.TextFromFileReader;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

public class SecondTestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        AuthenticationHolder_2.setAuth(false);

        List<String> list = TextFromFileReader.readLinesFromFile(TextFromFileReader.resPath + "loginAndPassword");
        String loginFromFile = list.get(0);
        String passwordFromFile = list.get(1);
        String loginFromFile_2 = list.get(3);
        String passwordFromFile_2 = list.get(4);
        String loginFromFile_3 = list.get(6);
        String passwordFromFile_3 = list.get(7);
        /// TODO: 29.08.2018 users from db, cause this not good solution 
        
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
            if (loginParam.equals(loginFromFile) && passwordParam.equals(passwordFromFile)) {
                AuthenticationHolder_2.setAuth(true);
            } else if (loginParam.equals(loginFromFile_2) && passwordParam.equals(passwordFromFile_2)) {
                AuthenticationHolder_2.setAuth(true);
            } else if (loginParam.equals(loginFromFile_3) && passwordParam.equals(passwordFromFile_3)) {
                AuthenticationHolder_2.setAuth(true);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
