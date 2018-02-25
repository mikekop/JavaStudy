package ru.logrocon.exceptions;

import ru.logrocon.kitchen.Kitchen;
import ru.logrocon.kitchen.queue.*;
import static ru.logrocon.utils.Print.*;

public class MainClass {

    public static void main(String[] args) {
        println("Работа с очередью готовки, в начале/процессе которой может что-то пойти не так");

        CookQueue queue = null;
        Kitchen kitchen = new Kitchen();

        println("Инициализация очереди, макс размером = 0");
        try {
            queue = new CookQueue(0);
        }catch (IncorrectQueueSizeException ex){
            printErrorMessage(ex);
        }

        int maxSize = 20;
        println("\nИнициализация очереди, макс размером = " + maxSize);
        try {
            queue = new CookQueue(maxSize);
        }catch (IncorrectQueueSizeException ex){
            printErrorMessage(ex);
        }

        println("Заполнение очереди 30 элементами");
        try {
            for (int i = 0; i < 30; i++) {
                queue.sendToCook(kitchen.generateRandomFood());
                println("Добавлеине в очередь " + (i+1));
            }
        }catch (QueueOverflowException ex){
            printErrorMessage(ex);
        }

        println("\nПолучение из очереди 25 элементов");
        try {
            for (int i = 0; i < 25; i++) {
                queue.getFromCook();
                println("Получение из очереди " + (i+1));
            }
        }catch (EmptyQueueException ex){
            printErrorMessage(ex);
        }
    }
}
