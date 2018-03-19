package ru.logrocon.lesson6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

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
            boolean hasUser = false;

            try {
                Database db = (Database) getServletContext().getAttribute("db");
                ResultSet result = db.execSql(string.Format(sql, login, password));
                hasUser = result.next();

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (userValid) {
                session.setAttribute("token", UUID.randomUUID());
                response.sendRedirect(request.getContextPath() + "/information");
            } else {
                resp.sendRedirect("./login.jsp");
            }
        }
    }
}