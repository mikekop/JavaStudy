package ru.logrocon.lesson1.food;

import ru.logrocon.lesson1.FoodBase;

/**
 * Класс, описывающий пирог
 */
public class Pie extends FoodBase {
    public Pie(){
        name = "Пирог";
    }

    @Override
    protected String prepare()
    {
        //do something
        return "поставлен в духовку";
    }

    @Override
    protected String finish()
    {
        //do something
        return "испекся";
    }
}
