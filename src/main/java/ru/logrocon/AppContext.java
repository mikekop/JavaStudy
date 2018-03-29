package ru.logrocon;

import org.springframework.context.annotation.*;

@Configuration
public class AppContext {
    @Bean
    public Speaker speaker(){
        return new Speaker();
    }

    @Bean
    public SpeakRepeater repeater(){
        SpeakRepeater speakRepeater = new SpeakRepeater();
        speakRepeater.setSpeaker(speaker());

        return speakRepeater;
    }
}
