package ru.logrocon.kitchen.queue;

public class IncorrectQueueSizeException extends Exception {
    IncorrectQueueSizeException(){super();}
    IncorrectQueueSizeException(String message){super(message);}
}
