package ru.logrocon.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.logrocon.lesson8.implementations.ScheduledTasks;
import ru.logrocon.lesson8.interfaces.Shower;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Lesson8Configuration.class);
        ScheduledTasks showerService = context.getBean(ScheduledTasks.class);
    }
}
