package ru.logrocon.lesson8;

import org.springframework.scheduling.annotation.Scheduled;
import ru.logrocon.lesson8.interfaces.Print;
import ru.logrocon.lesson8.interfaces.Show;

import java.util.Date;

public class ShowImpl implements Show {
    Print printService;

    public ShowImpl(Print printServiceDI){
        printService = printServiceDI;
    }

    @Scheduled(fixedRate = 10000) // 10 сек
    @Override
    public void show() {
        printService.print();
    }
}
