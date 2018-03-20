package ru.logrocon.lesson6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import static ru.logrocon.lesson6.DataBaseWorker.isFindUser;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    String sql = "select * from users where login='%s' and password='%s'";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (session != null) {
            if (isFindUser(login, password)) {
                session.setAttribute("token", UUID.randomUUID());
                response.sendRedirect(request.getContextPath() + "/information.jsp");
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}