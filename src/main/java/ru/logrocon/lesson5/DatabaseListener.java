package ru.logrocon.lesson5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class DatabaseListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        String url = sc.getInitParameter("urlDb");
        String user_name = sc.getInitParameter("userDb");
        String password = sc.getInitParameter("passwordDb");
        String database = sc.getInitParameter("database");
        Database db = new Database(url + database, user_name, password);
        sc.setAttribute("db", db);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            Database db = (Database) sc.getAttribute("db");
            if (db.getConnection() != null) {

                db.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}