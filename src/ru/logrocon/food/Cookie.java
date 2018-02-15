package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

public class Cookie extends FoodBase implements Food {
    public Cookie(){
        name = "Печенье";
    }

    @Override
    protected String Prepare()
    {
        //do something
        return "начинает готовиться";
    }

    @Override
    protected String Finish()
    {
        //do something
        return "успешно приготовлено";
    }
}
