package ru.logrocon.lesson5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if (login.toLowerCase().equals("admin") && password.equals("admin")) {
            session = req.getSession();
            session.setAttribute("isAuthorize", true);
            resp.sendRedirect(req.getContextPath());
        }
        else {
            resp.sendRedirect("./loginPage.jsp");
        }
    }
}
