package ru.logrocon.lesson5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();
        Object isAuthorizeParam = session.getAttribute("isAuthorize");
        if (isAuthorizeParam != null) {
            boolean isAuthorize = Boolean.parseBoolean(isAuthorizeParam.toString());
            if (isAuthorize) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        ((HttpServletResponse)servletResponse).sendRedirect("./loginPage.jsp");
    }

    @Override
    public void destroy() {

    }
}
