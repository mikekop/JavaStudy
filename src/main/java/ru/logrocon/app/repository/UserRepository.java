package ru.logrocon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.app.entity.Message;
import ru.logrocon.app.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    User getByLogin(String login);
}
