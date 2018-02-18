package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

/**
 * Класс, описывающий пирог
 */
public class Pie extends FoodBase implements Food {
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
