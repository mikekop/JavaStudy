package ru.logrocon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.logrocon.app.entity.Good;

import java.util.Set;

public interface GoodRepository extends JpaRepository<Good, Integer> {
    @Query("select g from Good g join g.customers c where c.login = :login")
    Set<Good> findByUserLogin(@Param("login") String login);
}
