package ru.logrocon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
@ComponentScan("ru.logrocon")
@EnableScheduling
public class Main implements SchedulingConfigurer {

    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

    public static void main(String[] args) throws InterruptedException {
        SpeakRepeater speakRepeater = ctx.getBean(SpeakRepeater.class);
        speakRepeater.startSpeaking();
        speakRepeater.setMessage("Привет!");
        // Подождем и поставим новое сообшение
        Thread.sleep(10100);
        speakRepeater.setMessage("Новое сообщение");
        Thread.sleep(10000);
        System.exit(0);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(1));
    }

}
