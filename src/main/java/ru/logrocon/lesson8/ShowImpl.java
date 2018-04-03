package ru.logrocon.lesson8;

import org.springframework.scheduling.annotation.Scheduled;
import ru.logrocon.lesson8.interfaces.Echo;
import ru.logrocon.lesson8.interfaces.Show;

public class ShowImpl implements Show {
    Echo echoService;

    public ShowImpl(Echo echoServiceDI){
        echoService = echoServiceDI;
    }

    @Scheduled(fixedRate = 10000) // 10 сек
    @Override
    public void show() {
        echoService.print("Arg");
    }
}
