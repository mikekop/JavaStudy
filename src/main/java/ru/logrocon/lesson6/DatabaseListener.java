package ru.logrocon.lesson5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;
import Utils;

public class DatabaseListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        String url = sc.getInitParameter("dataBaseUrl");
        String name = sc.getInitParameter("dataBaseUser");
        String password = sc.getInitParameter("dataBasePassword");
        String database = sc.getInitParameter("dataBaseName");
        if(Utils.isEmpty(url) || Utils.isEmpty(name) || Utils.isEmpty(password) || Utils.isEmpty(database)) {
            return;
        }
        Database db = new Database(url + database, name, password);
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