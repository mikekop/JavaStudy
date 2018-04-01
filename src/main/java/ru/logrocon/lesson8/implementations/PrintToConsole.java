package ru.logrocon.lesson8.implementations;

import ru.logrocon.lesson8.interfaces.Printer;

public class PrintToConsole implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
