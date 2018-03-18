package ru.logrocon.lesson5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        try {
            HttpSession session = req.getSession();
            if (session != null) {
                Object isAuthorizeParam = session.getAttribute("isAuthorize");
                if (isAuthorizeParam != null) {
                    boolean isAuthorize = Boolean.parseBoolean(isAuthorizeParam.toString());
                    if (isAuthorize) {
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }
            }
            ((HttpServletResponse) servletResponse).sendRedirect("./loginPage.jsp");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
