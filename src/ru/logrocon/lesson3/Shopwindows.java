package ru.logrocon.lesson3;

import ru.logrocon.lesson3.exceptions.GetCourseByNameException;
import ru.logrocon.lesson3.kitchen.Food;

public interface Shopwindows {
    void getCourseByName (String name) throws GetCourseByNameException;
    Food getFirstFood();
    void addFood(Food food);
    String displaySortByNameFoods();
    String displayAllFood();

}
