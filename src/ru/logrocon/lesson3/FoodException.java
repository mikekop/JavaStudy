package ru.logrocon.lesson3;

public class FoodException extends Exception {
    String name;
    FoodException(String name) {
        this.name = name;
    }
    @Override
    public String getMessage() {
        return "что-то пошло не так c " + name;
    }
}
