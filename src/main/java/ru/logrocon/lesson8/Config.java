package ru.logrocon.lesson8;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import ru.logrocon.lesson8.interfaces.Echo;
import ru.logrocon.lesson8.interfaces.Show;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableScheduling
public class Config implements SchedulingConfigurer {

    @Bean
    Echo echoService() {
        return new EchoImpl();
    }

    @Bean
    Show showService() {
        return new ShowImpl(echoService());
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(3);
    }
}