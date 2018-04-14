package ru.logrocon.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logrocon.app.entity.Good;
import ru.logrocon.app.repository.GoodRepository;

import java.util.Set;

@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    public Set<Good> getByUserLogin(String login){
        return goodRepository.findByUserLogin(login);
    }
}
