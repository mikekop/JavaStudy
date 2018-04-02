package ru.logrocon.lesson8;

import ru.logrocon.lesson8.interfaces.Print;

import java.util.Date;

public class PrintImpl implements Print {

    @Override
    public void print() {
        System.out.println(String.format("%s", new Date()));
    }
}
