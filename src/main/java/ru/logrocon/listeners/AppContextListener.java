package ru.logrocon.listeners;

import ru.logrocon.utils.DBManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String url = servletContext.getInitParameter("url");
        String userName = servletContext.getInitParameter("user_name");
        String password = servletContext.getInitParameter("password");
        String dbName = servletContext.getInitParameter("database");
        String dbConnType = servletContext.getInitParameter("connector");

        DBManager dbManager = new DBManager(url, userName, password, dbName, dbConnType);
        servletContext.setAttribute("db", dbManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        DBManager dbManager = (DBManager) servletContext.getAttribute("db");
        if(dbManager != null){
            dbManager.dispose();
            servletContext.removeAttribute("db");
        }
    }
}
