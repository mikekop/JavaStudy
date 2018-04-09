package ru.logrocon.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logrocon.app.entity.User;
import ru.logrocon.app.repository.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public User getByLogin(String login){return userRepository.getByLogin(login);}
}
