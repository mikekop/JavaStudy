package ru.logrocon.lesson3.task1;

import ru.logrocon.lesson3.task1.ShowCaseNotSort;

import java.util.Scanner;

public class ShowCaseTask {

    /**
     * Метод запуска витрины
     */
    public void work()
    {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Задача 1. Витрина.\r\nВыберите тип витрины");
            System.out.println("1 - Без сортировки");
            System.out.println("2 - С сортировкой");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        new ShowCaseNotSort().work();
                        break;
                    case 2:
                        new ShowCaseSort().work();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Введите 1, 2 или 0");
                }
            } else {
                System.out.println("Неверный ввод");
            }
        } while (var != 0);
    }
}
