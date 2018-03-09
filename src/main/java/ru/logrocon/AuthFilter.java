package ru.logrocon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AuthFilter implements Filter {

    private ArrayList<String> allowedUrls;

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getServletPath();
        // Если урл не находится в списке доступа для всех
        if(!allowedUrls.contains(url)){
            HttpSession session = req.getSession(false);
            // Нет сессии - не авторизованы
            if(session == null){
                res.sendRedirect("/");
            }
        }

        filterChain.doFilter(req, res);
    }
    @Override
    public void init(FilterConfig filterConfig) {
        String urls = filterConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

        allowedUrls = new ArrayList<>();

        while (token.hasMoreTokens()){
            allowedUrls.add(token.nextToken());
        }
    }
}
