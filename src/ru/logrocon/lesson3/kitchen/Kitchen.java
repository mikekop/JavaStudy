package ru.logrocon.lesson3.kitchen;

import ru.logrocon.lesson3.exceptions.CookException;

import java.util.Random;

public class Kitchen implements Kitchens {
    public Food cook(Food food) throws CookException {
        Random random = new Random();
        if(random.nextInt(50)<15){
            throw new CookException(String.format("%s сгорел, попробуйте ещё раз", food.name));
        }
        return  food;
    }
}
