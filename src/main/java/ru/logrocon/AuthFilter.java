package ru.logrocon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AuthFilter implements Filter {

    /**
     * Разрешенные урлы (получаю из конфига)
     */
    private ArrayList<String> allowedUrls;

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        String loginURI = req.getContextPath() + "/login";
        boolean loggedIn = session != null && session.getAttribute("name") != null;

        // Если мы на странице логина
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if(allowedUrls.contains(uri) || loginRequest || loggedIn){
            filterChain.doFilter(req, res);
        }else{
            session = req.getSession(true);
            // Придется схитрить и выставить сессию а потом затереть после отображения
            session.setAttribute("errorMessage", "Ресурс доступен только авторизованным пользователям!");
            res.sendRedirect(loginURI);
        }

    }
    @Override
    public void init(FilterConfig filterConfig) {
        String urls = filterConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        String contextPath = filterConfig.getServletContext().getContextPath();

        allowedUrls = new ArrayList<>();

        while (token.hasMoreTokens()){
            allowedUrls.add(contextPath + token.nextToken());
        }
    }
}
