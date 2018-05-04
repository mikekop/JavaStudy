package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "good")
public class Good implements Serializable {

    private int id;
    private String name;

    public Good() {
    }

    public Good(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Good {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}