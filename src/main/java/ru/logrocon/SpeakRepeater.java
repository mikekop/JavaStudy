package ru.logrocon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpeakRepeater {
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

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void startSpeaking(String messageToRepeat){
        this.messageToRepeat = messageToRepeat;
        executor.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
    }

    public void stopSpeaking(){
        executor.shutdown();
    }

    public void setMessage(String messageToRepeat) {
        this.messageToRepeat = messageToRepeat;
    }
}
