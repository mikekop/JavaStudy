package ru.logrocon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.app.entity.Good;

import java.util.Set;

public interface GoodRepository extends JpaRepository<Good, Integer> {
    Set<Good> getByUserLogin(String login);
}
