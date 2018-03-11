package ru.logrocon.lesson5;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter pw = servletResponse.getWriter();
        pw.printf("<H1>Фильтр</H1>");
    }

    @Override
    public void destroy() {

    }
}
