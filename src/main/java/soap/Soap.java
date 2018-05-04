package soap;

import model.Good;
import repository.GoodRepository;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "soap.WebServiceSEI", serviceName = "Soap")
public class Soap implements WebServiceSEI {

    @Override
    public List<Good> getGoods() {
        GoodRepository repo = new GoodRepository();
        List<Good> goods = repo.getGoods();
        return goods;
    }
}