package ru.logrocon.lesson3;

public class EmptyQueueException extends Exception {
    public EmptyQueueException(){
        super("");
    }
    @Override
    public String getMessage() {
        return "Очередь пуста";
    }
}
