package ru.logrocon.lesson9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.logrocon.lesson9.model.Users;
import ru.logrocon.lesson9.service.UserRepository;

@SpringBootApplication
public class Lesson9Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson9Application.class, args);
	}
}
