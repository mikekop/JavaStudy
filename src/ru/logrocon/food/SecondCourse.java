package ru.logrocon.food;

import ru.logrocon.Food;
import ru.logrocon.FoodBase;

public class SecondCourse extends FoodBase implements Food {
    public SecondCourse(){
        name = "Второе блюдо";
    }

    @Override
    protected String Prepare()
    {
        //do something
        return "жарится";
    }

    @Override
    protected String Finish()
    {
        //do something
        return "готово к употреблению";
    }
}