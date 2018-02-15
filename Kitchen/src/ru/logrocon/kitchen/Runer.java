package ru.logrocon.kitchen;

import java.util.ArrayList;

/**
 * Класс отвечающий за запуск программы
 */
public class Runer {
    /**
     * Метод точки входа в программу
     * @param args параметры командной строки при запуске приложения
     */
    public static  void main(String[] args){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add((new Borsch()));
        foods.add(new StewedCabbage());
        for (Food food : foods) {
            food.cook();
        }
    }
}
