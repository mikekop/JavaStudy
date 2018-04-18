package ru.logrocon.lesson10.model.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "good")
public class Good implements Serializable {

    private String name;

    public Good() {
    }

    public Good(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Good{" +
                ", name='" + name + '\'' +
                '}';
    }
}
