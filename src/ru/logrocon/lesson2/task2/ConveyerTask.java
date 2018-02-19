package ru.logrocon.lesson2.task2;

import ru.logrocon.lesson1.Food;
import ru.logrocon.lesson1.food.Cookie;
import ru.logrocon.lesson1.food.FirstCourse;
import ru.logrocon.lesson1.food.Pie;
import ru.logrocon.lesson1.food.SecondCourse;
import ru.logrocon.lesson2.task1.ShowCase;
import ru.logrocon.lesson2.task3.PerfomanceTask;

import java.util.LinkedList;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

public class ConveyerTask {

    /**
     * Конвейер блюд
     */
    private LinkedList<Food> conveyer;

    public ConveyerTask() {
        conveyer = new LinkedList<Food>();
    }

    /**
     * Метод запуска конвейера
     */
    public void work()
    {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Задача 2. Конвейер");
            System.out.println("1 - Заказать блюдо");
            System.out.println("2 - Приготовить блюдо");
            System.out.println("3 - Вывести очередь");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        offer();
                        break;
                    case 2:
                        cook();
                        break;
                    case 3:
                        showQueue();
                        break;
                    case 0:
                        System.out.println("До встречи!");
                        break;
                    default:
                        System.out.println("Введите 1, 2, 3 или 0");
                }
            } else {
                System.out.println("Неверный ввод");
            }
        } while (var != 0);
    }

    /**
     * Показать блюда в очереди
     */
    private void showQueue() {
        for (Food food: conveyer) {
            System.out.printf("%s - %s %n", conveyer.indexOf(food), food.toString());
        }
        System.out.println();
    }

    /**
     * Приготовить блюдо из очереди
     */
    private void cook() {
        if (!conveyer.isEmpty()) {
            Food food = conveyer.pop();
            food.cook();
        } else {
            System.out.println("Очередь пуста! Закажите что-нибудь\r\n");
        }
    }

    /**
     * Заказать блюдо
     */
    private void offer() {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Выберите блюдо:");
            System.out.println("1 - Первое блюдо");
            System.out.println("2 - Второе блюдо");
            System.out.println("3 - Пирог");
            System.out.println("4 - Печеньки");
            System.out.println("0 - Отмена");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        conveyer.offer(new FirstCourse());
                        var = 0;
                        break;
                    case 2:
                        conveyer.offer(new SecondCourse());
                        var = 0;
                        break;
                    case 3:
                        conveyer.offer(new Pie());
                        var = 0;
                        break;
                    case 4:
                        conveyer.offer(new Cookie());
                        var = 0;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Введите 1, 2, 3, 4 или 0");
                }
            } else {
                System.out.println("Неверный ввод");
            }
        } while (var != 0);
    }

}
