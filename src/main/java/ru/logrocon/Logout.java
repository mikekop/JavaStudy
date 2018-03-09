package ru.logrocon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.getSession().invalidate();
        request.setAttribute("successMessage", "Вы успешно вышли из системы");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}