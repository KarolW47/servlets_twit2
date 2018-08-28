package com.sda.twit2;

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
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
