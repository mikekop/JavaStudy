package ru.logrocon.lesson2;

import ru.logrocon.lesson2.kitchen.Food;

public interface Shopwindows {
    Food getCourseByName (String name);
    Food getFirstFood();
    String sortByNameFoods();
    String displayAllFood();
}
