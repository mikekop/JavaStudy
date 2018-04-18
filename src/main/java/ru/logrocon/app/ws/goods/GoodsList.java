package ru.logrocon.app.ws.goods;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class GoodsList {

    private ArrayList<GoodRes> goods;

    public void setGoods(ArrayList<GoodRes> goods) {
        this.goods = goods;
    }
    @XmlElementWrapper(name = "goodList", nillable = true)
    @XmlElement(name = "good")
    public ArrayList<GoodRes> getGoods() {
        return goods;
    }
}
