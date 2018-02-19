package ru.logrocon.lesson2;

public class FoodImpl implements Food {

    private String name;
    private boolean isCook;

    FoodImpl(String name) {
        String tempName = name;
        if (tempName.isEmpty()) {
            tempName = "Блюдо";
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

    public void cook() {
        System.out.println(String.format("Готовим %s", name));
        isCook = true;
        System.out.println(String.format("Приготовили %s", name));
    }
}
