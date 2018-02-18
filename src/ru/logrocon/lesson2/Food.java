package ru.logrocon.lesson2;

public abstract class Food implements Comparable<Food> {
    public String name ;
    public double weight;
    public TypeFood typeFood;

    public abstract String displayInfos();

    public abstract int compareTo(Food p);
}
