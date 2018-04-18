package ru.logrocon.lesson9.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.lesson9.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users getByUserName(String login);
}