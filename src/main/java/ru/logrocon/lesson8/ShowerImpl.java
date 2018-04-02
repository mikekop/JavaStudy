package ru.logrocon.lesson8;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowerImpl  implements Shower {
    Printer printerService;

    public ShowerImpl(Printer printerServiceDI){
        printerService = printerServiceDI;
    }

    @Scheduled(fixedRate = 10)
    @Override
    public void show() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy G HH:mm:ss z");
        printerService.print(String.format("Сейчас: %s", dateFormat.format(new Date())));
    }
}
