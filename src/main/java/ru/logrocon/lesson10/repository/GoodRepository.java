package ru.logrocon.lesson10.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.logrocon.lesson10.hibernate.HibernateUtil;
import ru.logrocon.lesson10.model.GoodEntity;
import ru.logrocon.lesson10.model.UserEntity;
import ru.logrocon.lesson10.model.dto.Good;

import java.util.ArrayList;
import java.util.List;

public class GoodRepository {

    public List<Good> getGoodsByLogin(String login){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        Query query = session.createQuery(
                " select * "
                        + " from user"
                        + " where login = :login "
        ).setString("login", login);

        UserEntity userEntity  =  (UserEntity)query;

        query = session.createQuery(
                " select * "
                        + " from good"
                        + " where userId = :userId "
        ).setInteger("userId", userEntity.getId());

        List<GoodEntity> goodEntities = (ArrayList<GoodEntity>)query.list();

        for (GoodEntity good : goodEntities)
        {
            //TODO
        }
        session.getTransaction().commit();
        session.close();

        return goodEntities;
    }
}
