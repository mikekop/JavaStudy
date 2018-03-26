package ru.logrocon.lesson7;

public class Item {
    public static Object lock = new Object();

    private final String name;
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public synchronized void bow(Item bower) {
        synchronized (lock) {
        System.out.format("%s: %s тут!%n", this.name, bower.getName());
        }
        bower.bowBack(this);
    }
    public synchronized void bowBack(Item bower) {
        synchronized (lock) {
        System.out.format("%s: %s ушла!%n", this.name, bower.getName());
        }
    }
}
