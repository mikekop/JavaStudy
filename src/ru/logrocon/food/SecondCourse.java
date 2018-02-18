package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

/**
 * Класс, описывающий второе блюдо
 */
public class SecondCourse extends FoodBase {
    public SecondCourse(){
        name = "Второе блюдо";
    }

    @Override
    protected String prepare()
    {
        //do something
        return "жарится";
    }

    @Override
    protected String finish()
    {
        //do something
        return "готово к употреблению";
    }
}