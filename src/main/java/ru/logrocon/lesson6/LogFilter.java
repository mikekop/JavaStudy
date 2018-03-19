package ru.logrocon.lesson5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {
    Logger logger;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = (Logger) session.getServletContext().getAttribute("log");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        logger.log(String.format("%s | %s", new Date(), req.getRequestURL()));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}