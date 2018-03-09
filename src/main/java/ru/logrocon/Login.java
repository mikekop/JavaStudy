package ru.logrocon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();

        if(name.equals("admin") && pass.equals("admin")){
            session.setAttribute("name", name);
            session.setAttribute("successMessage", "Вы успешно авторизованы");
            response.sendRedirect(request.getContextPath() + "/info");
        }else{
            session.setAttribute("errorMessage", "Неверный логин или пароль");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}