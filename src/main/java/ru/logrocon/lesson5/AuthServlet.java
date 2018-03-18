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

        boolean userValid = false;

        String urlDb = "jdbc:postgresql://52.166.138.17:5432/IM";
        String userDb = "postgres";
        String passwordDb = "rcut12345";
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlDb, userDb, passwordDb);
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(
                    "select * from dbo.\"Users\" " +
                            "where \"UserName\" = '" + login.toLowerCase() + "' " +
                            "and \"Password\" = '" + password + "' " +
                            "and \"DateOff\" is null");
            userValid = result.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (userValid) {
            session = req.getSession();
            session.setAttribute("isAuthorize", true);
            resp.sendRedirect(req.getContextPath());
        }
        else {
            resp.sendRedirect("./loginPage.jsp");
        }
    }
}
