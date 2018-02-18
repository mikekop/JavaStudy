package ru.logrocon.showcase;

import ru.logrocon.kitchen.Borsch;
import ru.logrocon.kitchen.Food;
import ru.logrocon.kitchen.PorkChop;
import ru.logrocon.kitchen.StewedCabbage;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Класс для ветрины на основе очереди
 */
public class ShowcaseQueue {

    /**
     * Очередь блюд
     */
    Queue<Food> queue;

    /**
     * Конструктор по умолчанию
     */
    public ShowcaseQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Метод постановки блюда на готовку
     */
    public void offer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Борщ");
        System.out.println("2 - Тушеная капуста ");
        System.out.println("3 - Свинная отбивная");
        System.out.print("Введите целое число от 1 до 3: ");
        if(sc.hasNextInt()) {
            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    queue.offer(new Borsch());
                    break;
                case 2:
                    queue.offer(new StewedCabbage());
                    break;
                case 3:
                    queue.offer(new PorkChop());
                    break;
                default:
                    System.out.println("неизвестное блюдо, ничего не добавлено");
            }

        } else {
            System.out.println("Вы ввели не целое число");
        }
    }

    /**
     * Метод приготовления следующего блюда
     */
    public void cook() {
        if (queue.peek() != null) {
            Food food = queue.remove();
            food.cook();
        }
        else {
            System.out.println("Очередь заказов пуста");
        }
    }

}
