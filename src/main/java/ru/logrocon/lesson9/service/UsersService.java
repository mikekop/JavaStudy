package ru.logrocon.lesson9.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.logrocon.lesson9.model.Users;
import ru.logrocon.lesson9.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;

    public Users getByLoginAndPass(String login, String pass){return userRepository.getByLoginAndPass(login, pass);}
}
