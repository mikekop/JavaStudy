package ru.logrocon.lesson8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import ru.logrocon.lesson8.implementations.PrintToConsole;
import ru.logrocon.lesson8.implementations.ScheduledTasks;
import ru.logrocon.lesson8.interfaces.Printer;
import ru.logrocon.lesson8.interfaces.Shower;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class Lesson8Configuration implements SchedulingConfigurer {

    @Bean
    Printer printerService() {
        return new PrintToConsole();
    }

    @Bean
    Shower showerService() {
        return new ScheduledTasks(printerService());
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(1);
    }
}
