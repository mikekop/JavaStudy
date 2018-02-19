package ru.logrocon.lesson1.food;

import ru.logrocon.lesson1.FoodBase;
import ru.logrocon.lesson1.Spices;

/**
 * Класс, описывающий первое блюдо
 */
public class FirstCourse extends FoodBase implements Spices {
    public FirstCourse(){
        name = "Первое блюдо";
    }

    @Override
    protected String prepare()
    {
        addSpice();
        //do something
        return "варится";
    }

    @Override
    protected String finish()
    {
        //do something
        return "сварено";
    }

    @Override
    public void addSpice() {
        System.out.println("Сперва добавим в " + name + " кориандр");
    }
}