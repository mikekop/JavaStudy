package ru.logrocon.lesson6;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter  {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login";
        boolean loggedIn = session != null && session.getAttribute("token") != null;

        // Если мы на странице логина
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loginRequest || loggedIn) {
            filterChain.doFilter(req, res);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException { }

    public void destroy() { }
}
