package ru.logrocon.lesson1;

public class Food {
    private String Name;
    private boolean IsCook;
    Food(String name) {
        Name = name;
    }

    public String getInfo() {
        return String.format("%s - %s", Name, (IsCook? "готово": "не готово"));
    }

    public void cook() {
        System.out.println(String.format("Готовим %s Класса %s", Name, this.getClass().getSimpleName()));
        IsCook = true;
        System.out.println(String.format("Приготовили %s Класса %s", Name, this.getClass().getSimpleName()));
    }
}
