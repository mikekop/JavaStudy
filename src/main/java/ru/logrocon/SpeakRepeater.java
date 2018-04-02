package ru.logrocon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SpeakRepeater {
    @Autowired
    private Speaker speaker;
    private String messageToRepeat;
    private ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();
    private Runnable task = new Runnable(){
        @Override
        public void run() {
            speaker.speak(SpeakRepeater.this.messageToRepeat);
        }
    };

    public void startSpeaking(String messageToRepeat){
        this.messageToRepeat = messageToRepeat;
        executor.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
    }
    @PreDestroy
    public void stopSpeaking(){
        executor.shutdown();
    }

    public void setMessage(String messageToRepeat) {
        this.messageToRepeat = messageToRepeat;
    }
}
