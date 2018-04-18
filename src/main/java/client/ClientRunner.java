package client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;;
import ru.logrocon.app.ws.goods.GoodsServiceWeb;

public class ClientRunner {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(GoodsServiceWeb.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/Service/Goods");
        GoodsServiceWeb service = (GoodsServiceWeb) jaxWsProxyFactoryBean.create();
        service.getByLogin("admin").getGoods().forEach(goodRes -> System.out.println("Found: " + goodRes));
    }
}
