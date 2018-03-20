package app.filters;

import app.dao.DAOImple;
import app.model.UserEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;

    String login;
    String password;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String login = request.getParameter("login") == null ? "" : request.getParameter("login");
        String password = request.getParameter("password")== null ? "" : request.getParameter("password");

        DAOImple daoImple = new DAOImple();
        UserEntity userEntity = daoImple.getUserById(1);

        this.login = userEntity.getLogin();
        this.password = userEntity.getPassword();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (login.equals(this.login)&&password.equals(this.password)){
            httpResponse.sendRedirect("privatePage.jsp");
        }else{
            httpResponse.sendRedirect("publicPage.jsp");
        }

        //chain.doFilter(request, response);
    }

    public void destroy() {
        this.filterConfig = null;
    }
}