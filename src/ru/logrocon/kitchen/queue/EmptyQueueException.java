package ru.logrocon.kitchen.queue;

public class EmptyQueueException extends Exception {
    EmptyQueueException(){super();}
    EmptyQueueException(String message){super(message);}
}
