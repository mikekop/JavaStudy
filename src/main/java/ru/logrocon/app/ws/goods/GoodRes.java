package ru.logrocon.app.ws.goods;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "good")
public class GoodRes{

    private String name;
    private Integer id;

    @XmlElement(name = "name")
    public String getName(){
        return name;
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
