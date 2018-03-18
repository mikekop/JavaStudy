package ru.logrocon.lesson5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        String login = "";
        if (session != null) {
            login = (String) session.getAttribute("login");
        }

        Logger logger = (Logger) session.getServletContext().getAttribute("log");
        logger.log(String.format("%s | Пользователь %s с сессией %s вызвал %s\r\n", new Date(), login == null ? "" : login , req.getRequestedSessionId(), req.getRequestURL()));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}