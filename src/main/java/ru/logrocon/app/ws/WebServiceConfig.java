package ru.logrocon.app.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.logrocon.app.service.GoodService;
import ru.logrocon.app.ws.goods.GoodsServiceWebImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private GoodService goodService;

    @Bean
    public Endpoint goodsEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, new GoodsServiceWebImpl(goodService));
        endpoint.publish("/Goods");
        return endpoint;
    }
}
