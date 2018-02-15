package ru.logrocon;

/**
 * Базовый класс для блюд
 */
public class FoodBase {
    protected String name;


    public void cook() {
        System.out.println(String.join(" ", name, prepare()));
        System.out.println(String.join(" ", name, finish()));
    }

    protected String prepare()
    {
        return "готовится из стандартных продуктов";
    }

    protected String finish()
    {
        return "приготовлено из стандартных продуктов";
    }
}
