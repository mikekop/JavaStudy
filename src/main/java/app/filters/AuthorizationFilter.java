package app.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WD45 on 18.03.2018.
 */
public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;

    final String login = "admin";
    final String password = "admin";

    public void init(FilterConfig filterConfig) throws ServletException {
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
