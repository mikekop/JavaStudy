package ru.logrocon.lesson10.main;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import ru.logrocon.lesson10.model.dto.Good;
import ru.logrocon.lesson10.soap.WebserviceSEI;

import java.util.List;

public class Start {

    public static void main(String[] args) {
        testSOAPFromClient();
    }

    private static void testSOAPFromClient() {
        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WebserviceSEI.class);
        factoryBean.setAddress(soapServiceUrl);

        WebserviceSEI webserviceSEI = (WebserviceSEI) factoryBean.create();

        List<Good> result = webserviceSEI.getGoods("admin");
        System.out.println("Result: " + result);
    }

}
