package ru.logrocon.app.ws.goods;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "good")
@XmlAccessorType(XmlAccessType.NONE)
public class GoodRes{
    @XmlElement(name = "name")
    private String name;
    @XmlAttribute(name = "name")
    private Integer id;

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Good["+id+"]: " + name;
    }
}
