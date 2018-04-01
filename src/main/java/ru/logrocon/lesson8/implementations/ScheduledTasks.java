package ru.logrocon.lesson8.implementations;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.logrocon.lesson8.interfaces.Printer;
import ru.logrocon.lesson8.interfaces.Shower;

import java.util.Date;

public class ScheduledTasks implements Shower {
    Printer printerService;

    public ScheduledTasks(Printer printerServiceDI){
        printerService = printerServiceDI;
    }

    @Scheduled(fixedRate = 10 * 1000)
    @Override
    public void show() {
        printerService.print(String.format("Текущее время: %s", new Date()));
    }
}
