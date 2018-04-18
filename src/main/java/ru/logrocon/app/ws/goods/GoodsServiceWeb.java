package ru.logrocon.app.ws.goods;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Goods")
public interface GoodsServiceWeb {
    @WebMethod
    GoodsList getByLogin(@WebParam(name = "login") String login);
}
