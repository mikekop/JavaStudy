package ru.logrocon;

public class FoodBase implements  Food{
    protected String name;

    @Override
    public void Cook() {
        System.out.println(String.join(" ", name, "готовится"));
        System.out.println(String.join(" ", name, "приготовлено"));
    }
}
