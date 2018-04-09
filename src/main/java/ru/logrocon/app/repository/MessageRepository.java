package ru.logrocon.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.app.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
