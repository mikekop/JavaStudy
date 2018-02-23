package ru.logrocon.lesson1.food;

import ru.logrocon.lesson1.FoodBase;
import ru.logrocon.lesson1.FoodException;
import ru.logrocon.lesson1.Spices;

/**
 * Класс, описывающий первое блюдо
 */
public class FirstCourse extends FoodBase implements Spices {
    public FirstCourse(){
        name = "Первое блюдо";
    }

    public static int spiceQnt = 3;

    @Override
    protected String prepare() throws FoodException {
        if (spiceQnt > 0) {
            addSpice();
            spiceQnt--;
            return "варится";
        } else {
            throw new FoodException("Специи закончились");
        }
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