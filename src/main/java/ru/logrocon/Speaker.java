package ru.logrocon;

import org.springframework.stereotype.Service;

@Service
public class Speaker {

    public void speak(String message){
        System.out.println(message);
    }
}
