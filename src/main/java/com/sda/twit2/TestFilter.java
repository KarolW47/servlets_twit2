package com.sda.twit2;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        AuthenticationHolder.setAuth(false);

        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            Object currentParam = names.nextElement();
            if (currentParam.equals("secret")) {
                String secretParam = request.getParameter("secret");
                if (secretParam != null) {
                    if (secretParam.equals("123")) {
                        AuthenticationHolder.setAuth(true);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
