package repository;

import entity.UserEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;

public class UserRepository {

    public static UserEntity getUserById(int id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserEntity userEntity = (UserEntity)session.get(UserEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }

    public static UserEntity getUserByLogin(String login ){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "select * from user where login = "+login;
        UserEntity userEntity = (UserEntity)session.createQuery(query);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }
}
