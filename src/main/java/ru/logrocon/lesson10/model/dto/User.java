package ru.logrocon.lesson10.model.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "user")
public class User implements Serializable{

    private String login;
    private String password;
    private List<Good> goodsList;

    public User() {
    }

    public User(String login, String password, List<Good> goodsList) {
        this.login = login;
        this.password = password;
        this.goodsList = goodsList;
    }

    public String getLogin() {
        return login;
    }

    public void getLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Good> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Good> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "User{" +
                "goodsList=" + goodsList +
                ", login='" + login + '\'' +
                ", login=" + login +
                '}';
    }
}
