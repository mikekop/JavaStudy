package ru.logrocon.lesson10.soap;

import ru.logrocon.lesson10.model.dto.Good;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.logrocon.lesson10.soap.WebserviceSEI",
        serviceName = "Soap")
public class Soap implements WebserviceSEI {

    @Override
    public List<Good> getGoods( String login) {
        return null;
    }
}
