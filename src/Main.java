import Deadlock.Deadlock;
import Simultaneous.SimultaneousStart;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Выберите задание:");
            System.out.println("1 - Одновременный старт");
            System.out.println("2 - Дедлок");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        new SimultaneousStart();
                        var = -1;
                        break;
                    case 2:
                        new Deadlock();
                        var = -1;
                        break;
                    case 0:
                        System.out.println("До встречи!");
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
