package ru.logrocon;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Info extends HttpServlet {


    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("name", request.getSession().getAttribute("name"));

        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        request.getSession().setAttribute("name", name);

        response.sendRedirect(request.getContextPath()+"/info");
    }
}
