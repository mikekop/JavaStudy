package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

public class FirstCourse extends FoodBase implements Food {
    public FirstCourse(){
        name = "Первое блюдо";
    }

    @Override
    protected String Prepare()
    {
        //do something
        return "подогревается";
    }

    @Override
    protected String Finish()
    {
        //do something
        return "подано";
    }
}