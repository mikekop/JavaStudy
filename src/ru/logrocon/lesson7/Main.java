package ru.logrocon.lesson7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int var;
        System.out.println("1 - Одновременный старт");
        System.out.println("2 - Дедлок");
        Process pr = null;
        if (sc.hasNextInt()) {
            var = sc.nextInt();
            switch (var) {
                case 1:
                    pr = new Simultaneous(1);
                    break;
                case 2:
                    pr = new DeadLock();
                    break;
            }
            pr.start();
        } else {
                System.out.println("Неверный ввод");
        }
    }
}
