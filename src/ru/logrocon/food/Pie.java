package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

public class Pie extends FoodBase implements Food {
    public Pie(){
        name = "Пирог";
    }
    @Override
    protected String Prepare()
    {
        //do something
        return "поставлен в духовку";
    }

    @Override
    protected String Finish()
    {
        //do something
        return "испекся";
    }
}
