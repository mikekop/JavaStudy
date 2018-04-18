package ru.logrocon.lesson10.soap;


import ru.logrocon.lesson10.model.dto.Good;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface WebserviceSEI {

    @WebMethod
    List<Good> getGoods( String login);
}
