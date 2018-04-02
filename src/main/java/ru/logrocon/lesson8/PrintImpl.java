package ru.logrocon.lesson8;

import ru.logrocon.lesson8.interfaces.Print;

public class PrintImpl implements Print {

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
