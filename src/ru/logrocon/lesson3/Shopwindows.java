package ru.logrocon.lesson3;

import ru.logrocon.lesson3.exceptions.CourseByNameException;
import ru.logrocon.lesson3.kitchen.Food;

public interface Shopwindows {
    void getCourseByName (String name) throws CourseByNameException;
    Food getFirstFood();
    String sortByNameFoods();
    String displayAllFood();
}
