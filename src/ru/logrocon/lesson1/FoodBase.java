package ru.logrocon.lesson1;

/**
 * Базовый класс для блюд
 */
public abstract class FoodBase implements Food {
    protected String name;


    public void cook() {
        System.out.println(String.join(" ", name, prepare()));
        System.out.println(String.join(" ", name, finish()));
    }

    /**
     * Метод готовки
     */
    protected abstract String prepare();

    /**
     * Метод окончания готовки
     */
    protected abstract String finish();
}
