package app.servlets;

import app.UserCheck;
import app.dao.DAOImple;
import app.model.UserEntity;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationServlet extends HttpServlet {

    String login;
    String password;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//
//        DAOImple daoImple = new DAOImple();
//
//        HttpSession session = req.getSession(true);
//
//        try {
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }

    }
}