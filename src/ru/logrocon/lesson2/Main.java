package ru.logrocon.lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Поиск по названию");
        System.out.println("2. Конвеер");
        Scanner sc = new Scanner(System.in);
        Worker worker = null;
        if (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1:
                    worker = new FinderWorkerImpl();
                    worker.start();
                    break;
                case 2:
                    worker = new QueueWorkerImpl();
                    worker.start();
                    break;
                default:
                    System.out.println("Мимо");
                    break;
            }
        }
    }
}
