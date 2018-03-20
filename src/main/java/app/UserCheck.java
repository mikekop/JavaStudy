package app;

import app.model.UserEntity;
import org.hibernate.Session;

public  class UserCheck {

    //Session session = HibernateUtil.getSessionFactory().openSession();

    public  boolean Check(int id)
    {
//        return session.load(UserEntity.class, id);
        return false;
    }

}
