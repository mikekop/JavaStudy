package ru.logrocon.lesson5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class LogListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        String path = sc.getInitParameter("logPath");
        Logger log = new Logger(path);
        sc.setAttribute("log", log);
    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }
}