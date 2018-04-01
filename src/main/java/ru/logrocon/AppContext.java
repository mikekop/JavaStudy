package ru.logrocon;

import org.springframework.context.annotation.*;

@Configuration
public class AppContext {
    @Bean
    public Speaker speaker(){
        return new Speaker();
    }

    @Bean(destroyMethod="stopSpeaking")
    public SpeakRepeater repeater(){
        return new SpeakRepeater(speaker());
    }
}
