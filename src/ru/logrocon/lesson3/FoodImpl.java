package ru.logrocon.lesson3;


import java.util.Random;

import static ru.logrocon.lesson3.Utils.getRandomBoolean;

public class FoodImpl implements Food {

    private String name;
    private boolean isCook;

    FoodImpl(String name) throws ArgumentNullException {
        String tempName = name;
        if (tempName.isEmpty()) {
            throw new ArgumentNullException("name");
        }
        this.name = tempName;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getInfo() {
        return String.format("%s - %s", name, (isCook ? "готово": "не готово"));
    }

    public void cook() throws FoodException{
        System.out.println(String.format("Готовим %s", name));
        isCook = getRandomBoolean();
        if (!isCook)
            throw new FoodException(name);
        System.out.println(String.format("Приготовили %s", name));
    }
}
