package ru.logrocon.lesson5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class AuthServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        if (session != null) {
            boolean userValid = false;

            try {
                Database db = (Database) getServletContext().getAttribute("db");
                ResultSet result = db.execSql(
                        "select * from dbo.\"Users\" " +
                                "where \"UserName\" = '" + login.toLowerCase() + "' " +
                                "and \"Password\" = '" + password + "' " +
                                "and \"DateOff\" is null");
                userValid = result.next();

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (userValid) {
                session.setAttribute("isAuthorize", true);
                session.setAttribute("login", login);
                resp.sendRedirect(req.getContextPath());
            } else {
                resp.sendRedirect("./loginPage.jsp");
            }
        }
    }
}