package ru.logrocon.lesson8;

import ru.logrocon.lesson8.interfaces.Echo;

import java.util.Date;

public class EchoImpl implements Echo {

    @Override
    public void print(String s) {
        System.out.println(String.format("s: %s", new Date()));
    }
}
