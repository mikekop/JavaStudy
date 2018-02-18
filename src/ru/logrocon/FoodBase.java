package ru.logrocon;

/**
 * Базовый класс для блюд
 */
public abstract class FoodBase {
    protected String name;


    public void cook() {
        System.out.println(String.join(" ", name, prepare()));
        System.out.println(String.join(" ", name, finish()));
    }

    protected abstract String prepare();

    protected abstract String finish();
}
