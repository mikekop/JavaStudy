package ru.logrocon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

@Service
public class SpeakRepeater {
    @Autowired
    private Speaker speaker;
    private String messageToRepeat;
    private boolean isRunning = false;

    // Каждые 10 секунд
    @Scheduled(fixedRate = 10000)
    private void speak(){
        if(isRunning){
            speaker.speak(SpeakRepeater.this.messageToRepeat);
        }
    }

    public void startSpeaking(){isRunning = true;}
    public void stopSpeaking(){isRunning = false;}

    public void setMessage(String messageToRepeat) {
        this.messageToRepeat = messageToRepeat;
    }
}
