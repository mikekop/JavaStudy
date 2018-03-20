package app;

import app.dao.UserEntity;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;

public class Main {

    public static void main (String[] arg)
    {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        //session.beginTransaction();

        UserEntity userEntity = session.load(UserEntity.class, 1);

        userEntity.getLogin();

        //session.save(userEntity);
        //session.getTransaction().commit();

        session.close();

        System.out.println(userEntity.getLogin());
    }
}