package app.filters;

import app.HibernateSessionFactory;
import app.dao.UserEntity;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;

    String login;
    String password;

    public void init(FilterConfig filterConfig) throws ServletException {

//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        UserEntity userEntity = session.load(UserEntity.class, 1);
//        login = userEntity.getLogin();
//        password = userEntity.getPassword();
//        session.close();
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

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