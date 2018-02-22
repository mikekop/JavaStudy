package ru.logrocon.lesson3;

import ru.logrocon.lesson3.exceptions.GetCourseException;
import ru.logrocon.lesson3.kitchen.Food;

public interface Shopwindows {
    void getCourseByName (String name) throws GetCourseException;
    void getFirstFood() throws GetCourseException;
    void addFood(Food food);
    String displaySortByNameFoods();
    String displayAllFood();

}
