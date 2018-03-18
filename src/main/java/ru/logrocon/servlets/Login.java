package ru.logrocon.servlets;

import ru.logrocon.utils.DBManager;
import ru.logrocon.utils.SocketSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        SocketSender socketSender = new SocketSender();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        socketSender.println(String.format("Зарегистрирована попытка авторизации %s:%s", name, pass));

        HttpSession session = request.getSession(true);

        // TODO: вынести работу с данными из БД за слой абстракции (репозитории?)
        DBManager db = (DBManager) getServletContext().getAttribute("db");

        String sql = "select id, login from users where login=? and password=?";

        try(PreparedStatement st = db.getPreparedStatement(sql)) {
            st.setString(1, name);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();

            // Если нашли запись
            if(rs.next()){
                // Запомним в сессию данные
                session.setAttribute("name", rs.getString("login"));
                session.setAttribute("successMessage", "Вы успешно авторизованы");
                socketSender.println("Пользователь успешно авторизован");
                response.sendRedirect("info.jsp");
            }else{
                session.setAttribute("errorMessage", "Неверный логин или пароль");
                socketSender.println("Пользователь не найден");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
            rs.close();
        }catch (SQLException e){
            session.setAttribute("errorMessage", "Произошла ошибка");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }finally {
            socketSender.println("Процесс авторизации окончен");
            socketSender.dispose();
        }
    }
}