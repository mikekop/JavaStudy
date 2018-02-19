package ru.logrocon.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Поиск по названию");
        System.out.println("2. Конвеер");
        System.out.println("3. Производительность");
        Scanner sc = new Scanner(System.in);
        Worker worker = null;
        if (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1:
                    worker = new FinderWorkerImpl();
                    break;
                case 2:
                    worker = new QueueWorkerImpl();
                    break;
                case 3:
                    worker = new PerfomanceWorkerImpl(1500000);
                    break;
                default:
                    System.out.println("Мимо");
                    break;
            }
            if (worker !=null ) {
                worker.start();
            }
        }
    }
}
