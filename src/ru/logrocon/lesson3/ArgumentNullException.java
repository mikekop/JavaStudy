package ru.logrocon.lesson3;

public class ArgumentNullException extends Exception {
   public ArgumentNullException(String name) {
        super(name);
    }

    @Override
    public String getMessage() {
        return String.format("Ошибка в параметре: %s", super.getMessage());
    }
}
