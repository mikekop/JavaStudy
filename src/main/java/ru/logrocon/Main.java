package ru.logrocon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

    public static void main(String[] args) throws InterruptedException {
        SpeakRepeater speakRepeater = ctx.getBean(SpeakRepeater.class);

        speakRepeater.startSpeaking("Привет!");
        // Подождем и поставим новое сообшение
        Thread.sleep(10100);
        speakRepeater.setMessage("Новое сообщение");
        // По
        Thread.sleep(20000);
        speakRepeater.stopSpeaking();
    }
}
