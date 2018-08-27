package com.sda.twit2;

import javax.servlet.*;
import java.io.IOException;

public class ThirdTestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println(3);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
