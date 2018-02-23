package ru.logrocon.lesson3.task2;

import ru.logrocon.lesson1.Food;
import ru.logrocon.lesson1.FoodException;
import ru.logrocon.lesson1.food.Cookie;
import ru.logrocon.lesson1.food.FirstCourse;
import ru.logrocon.lesson1.food.Pie;
import ru.logrocon.lesson1.food.SecondCourse;
import ru.logrocon.lesson3.task1.ShowCase;
import ru.logrocon.lesson3.task3.PerfomanceTask;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

public class ConveyerTask {

    /**
     * Конвейер блюд
     */
    private LinkedList<Food> conveyer;

    /**
     * Метод запуска конвейера
     */
    public void work()
    {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Задача 2. Конвейер");
            System.out.println("1 - Создать конвейер");
            System.out.println("2 - Заказать блюдо");
            System.out.println("3 - Приготовить блюдо");
            System.out.println("4 - Вывести очередь");
            System.out.println("5 - Закупить специи");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        createConveyer();
                        break;
                    case 2:
                        offer();
                        break;
                    case 3:
                        cook();
                        break;
                    case 4:
                        showQueue();
                        break;
                    case 5:
                        buySpices();
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
     * Закупить специи
     */
    private void buySpices() {
        FirstCourse.spiceQnt++;
    }

    /**
     * Метод создания конвейера
     */
    private void createConveyer() {
        conveyer = new LinkedList<Food>();
        System.out.println("Конвейер создан");
    }

    /**
     * Показать блюда в очереди
     */
    private void showQueue() {
        try {
            for (Food food : conveyer) {
                System.out.printf("%s - %s %n", conveyer.indexOf(food), food.toString());
            }
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Сперва создайте конвейер\r\n");
        }
    }

    /**
     * Приготовить блюдо из очереди
     */
    private void cook() {
        try {
            Food food = conveyer.getFirst();
            food.cook();
            conveyer.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Очередь пуста! Закажите что-нибудь\n");
        }
        catch (NullPointerException e) {
            System.out.println("Сперва создайте конвейер\r\n");
        }
        catch (FoodException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Заказать блюдо
     */
    private void offer() {
        try {
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
        catch (NullPointerException e)
        {
            System.out.println("Ошибка при постановке в очередь - конвейер не создан\r\n");
        }
    }

}
