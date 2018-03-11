package ru.logrocon.lesson5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class Login extends HttpServlet {

    String defaultLogin = "admin";
    String defaultPassword = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (login.equals(defaultLogin) && password.equals(defaultPassword)) {
            session.setAttribute("token", UUID.randomUUID());
            response.sendRedirect(request.getContextPath() + "/information");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}