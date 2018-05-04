package repository;


import data.model.EntityGoods;
import hibernate.HibernateUtil;
import model.Good;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GoodRepository {

    public List<Good> getGoods(){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select g from EntityGoods g");

        List<EntityGoods> goodEntities = (ArrayList<EntityGoods>)query.list();
        List<Good> result = new ArrayList();

        for (EntityGoods good : goodEntities) {
            Good res = new Good();
            res.setId(good.getId());
            res.setName(good.getName());
            result.add(res);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
