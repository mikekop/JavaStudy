package ru.logrocon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if(name.equals("admin") && pass.equals("admin")){
            request.getSession().setAttribute("name", name);
            request.setAttribute("successMessage", "Вы успешно авторизованы");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }else{
            request.setAttribute("errorMessage", "Неверный логин или пароль");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}