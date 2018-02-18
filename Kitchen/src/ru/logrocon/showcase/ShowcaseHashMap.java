package ru.logrocon.showcase;

import ru.logrocon.kitchen.Food;

import java.util.HashMap;

/**
 * Класс для ветрины на основе HashMap
 */
public class ShowcaseHashMap extends ShowcaseBase {

    /**
     * Конструктор по умолчанию
     */
    public  ShowcaseHashMap() {
        super();
        map = new HashMap<>();
    }
}
