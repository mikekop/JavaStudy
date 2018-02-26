package ru.logrocon.lesson3;

import java.util.Scanner;
import static ru.logrocon.lesson3.Utils.printError;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Поиск по названию");
        System.out.println("2. Конвеер");
        System.out.println("3. Производительность");
        System.out.println("4. ReflectionWorker");
        Scanner sc = new Scanner(System.in);
        Worker worker = null;
        try {
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
                    case 4:
                        worker = new ReflectionWorker();
                        break;
                    default:
                        throw new ArgumentNullException("Menu Item");
                }
                worker.start();
            }
        }
        catch (Exception ex) {
            printError(ex);
        }

    }
}
