package ru.logrocon.lesson6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.logrocon.lesson6.dataBase.UsersEntity;

import java.util.List;

public class DataBaseWorker {
    public static boolean isFindUser(String login, String password) {
        boolean result = false;
        try {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        Query query = session1.createQuery("SELECT id, login, password FROM UsersEntity WHERE login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<UsersEntity> users = (List<UsersEntity>)query.list();
        for (UsersEntity user: users) {
            System.out.println(user.getLogin());
        }
        if(!users.isEmpty()) {
            result = true;
        }
        session1.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(result);
            return result;
        }
    }
}
