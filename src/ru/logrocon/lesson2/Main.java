package ru.logrocon.lesson2;

import ru.logrocon.lesson2.task1.ShowCase;
import ru.logrocon.lesson2.task2.ConveyerTask;
import ru.logrocon.lesson2.task3.PerfomanceTask;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Урок 2. Выберите задание:");
            System.out.println("1 - Витрина");
            System.out.println("2 - Конвеер");
            System.out.println("3 - Оптимизация метода");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        new ShowCase();
                        break;
                    case 2:
                        new ConveyerTask().work();
                        break;
                    case 3:
                        new PerfomanceTask();
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
}