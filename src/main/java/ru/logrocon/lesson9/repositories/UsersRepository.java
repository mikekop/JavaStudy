package ru.logrocon.lesson9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.lesson9.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
    Users getByLoginAndPass(String login, String pass);
}

