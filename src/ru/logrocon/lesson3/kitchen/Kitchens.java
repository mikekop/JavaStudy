package ru.logrocon.lesson3.kitchen;
import ru.logrocon.lesson3.exceptions.CookException;

public interface Kitchens {
    Food cook(Food food) throws CookException;
}
