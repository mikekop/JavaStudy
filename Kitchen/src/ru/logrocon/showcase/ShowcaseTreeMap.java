package ru.logrocon.showcase;

import ru.logrocon.kitchen.Food;

import java.util.TreeMap;

/**
 * Класс для ветрины на основе TreeMap
 */
public class ShowcaseTreeMap extends ShowcaseBase {

    /**
     * Конструктор по умолчанию
     */
    public  ShowcaseTreeMap() {
        super();
        map = new TreeMap<>();
    }
}
