package ru.logrocon.app.ws.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.logrocon.app.service.GoodService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@javax.jws.WebService(endpointInterface = "ru.logrocon.app.ws.goods.GoodsServiceWeb")
// @Component
public class GoodsServiceWebImpl implements GoodsServiceWeb{
    private static final Logger log = LoggerFactory.getLogger(GoodsServiceWebImpl.class);
    private GoodService goodService;
    public GoodsServiceWebImpl(GoodService service){
        goodService = service;
    }

    @Override
    public GoodsList getByLogin(String login) {
        GoodsList result = new GoodsList();
        // Преобразуем
        // Вспомним старый добрый JS ;)
        List<GoodRes> goods = goodService.getByUserLogin(login)
                                .stream()
                                .map(g -> {
                                    GoodRes res = new GoodRes();
                                    res.setId(g.getGoodId());
                                    res.setName(g.getName());
                                    return res;
                                })
                                .collect(Collectors.toList());
        log.info("i found " + goods.size() + " goods");
        result.setGoods(new ArrayList<>(goods));

        return result;
    }
}
