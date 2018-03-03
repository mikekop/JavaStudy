package ru.logrocon;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.logrocon.CookieHelper.*;

public class Info extends HttpServlet {


    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = getCookieValue("name", request);
        request.setAttribute("name", name);

        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        addCookie("name", name, response);

        response.sendRedirect(request.getContextPath()+"/info");
    }
}
