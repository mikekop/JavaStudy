package ru.logrocon;

public class FoodBase {
    protected String name;


    public void Cook() {
        System.out.println(String.join(" ", name, Prepare()));
        System.out.println(String.join(" ", name, Finish()));
    }

    protected String Prepare()
    {
        return "готовится из стандартных продуктов";
    }

    protected String Finish()
    {
        return "приготовлено из стандартных продуктов";
    }
}
