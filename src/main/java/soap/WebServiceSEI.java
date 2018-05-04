package soap;

import model.Good;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface WebServiceSEI {

    @WebMethod
    List<Good> getGoods();
}