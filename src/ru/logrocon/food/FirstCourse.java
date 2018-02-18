package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;
import ru.logrocon.Spices;

/**
 * Класс, описывающий первое блюдо
 */
public class FirstCourse extends FoodBase implements Spices{
    public FirstCourse(){
        name = "Первое блюдо";
        addSpice();
    }

    @Override
    protected String prepare()
    {
        //do something
        return "подогревается";
    }

    @Override
    protected String finish()
    {
        //do something
        return "подано";
    }

    @Override
    public void addSpice() {
        System.out.println("Сперва добавим в " + name + " кориандр");
    }
}