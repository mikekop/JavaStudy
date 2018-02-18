package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

/**
 * Класс, описывающий печеньки
 */
public class Cookie extends FoodBase {
    public Cookie(){
        name = "Печенье";
    }

    @Override
    protected String prepare()
    {
        //do something
        return "начинает готовиться";
    }

    @Override
    protected String finish()
    {
        //do something
        return "успешно приготовлено";
    }
}
