package app.dao;

import app.HibernateUtil;
import app.model.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;

public class DAOImple {

    public UserEntity getUserById(int id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserEntity userEntity = session.load(UserEntity.class, 1);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }
}
