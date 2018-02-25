package ru.logrocon.kitchen.queue;

public class QueueOverflowException extends Exception {
    QueueOverflowException(){super();}
    QueueOverflowException(String message){super(message);}
}
