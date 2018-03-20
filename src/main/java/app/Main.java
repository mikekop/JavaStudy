package app;

import app.dao.DAOImple;
import app.model.UserEntity;

public class Main {

    public static void main (String[] arg)
    {
        DAOImple daoImple = new DAOImple();
        UserEntity userEntity = daoImple.getUserById(1);
        System.out.println(userEntity.getLogin());
    }
}