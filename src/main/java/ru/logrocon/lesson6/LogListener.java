package ru.logrocon.lesson6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        String path = sc.getInitParameter("log");
        Logger log = new Logger(path);
        sc.setAttribute("log", log);
    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }
}