package ru.logrocon.showcase;

import ru.logrocon.kitchen.*;

import java.util.*;

/**
 * Класс отвечающий за запуск программы
 */
public class Runer {
    /**
     * Метод точки входа в программу
     *
     * @param args параметры командной строки при запуске приложения
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Ветрина на основе Map ");
        System.out.println("2 - Ветрина по принципу очереди ");
        System.out.println("3 - Оптимизация перебора Map");
        System.out.print("Введите целое число от 1 до 3: ");
        if(sc.hasNextInt()) {
            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    showMapDemo();
                    break;
                case 2:
                    showQueueDemo();
                    break;
                case 3:
                    showSampleOptimization();
                    break;
                default:
                    System.out.println("Введено число не от 1 до 3");
            }
        } else {
            System.out.println("Вы ввели не целое число");
        }
    }

    private static void showQueueDemo() {
        Scanner sc = new Scanner(System.in);
        ShowcaseQueue queue = new ShowcaseQueue();
        int answer = -1;
        do {
            System.out.println("1 - Добавить блюдо");
            System.out.println("2 - Приготовить блюдо");
            System.out.println("0 - Выход");
            System.out.print("Введите целое число от 1 до 2 или 0 для выхода ");
            if (sc.hasNextInt()) {
                answer = sc.nextInt();
                switch (answer) {
                    case 1:
                        queue.offer();
                        break;
                    case 2:
                        queue.cook();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Введено число не от 1 до 2 или 0");
                }
            } else {
                System.out.println("Вы ввели не целое число");
            }
        } while (answer != 0);
    }

    static void showMapDemo() {
        System.out.println("Работа с ветринами на основе Map");
        System.out.println("1. Создаем две витрины и заполняем из 10 элементами");
        Random rnd = new Random();
        ShowcaseHashMap hash = new ShowcaseHashMap();
        ShowcaseTreeMap tree = new ShowcaseTreeMap();
        for (int i = 0; i < 10; i++) {
            switch (rnd.nextInt(3)){
                case 0:
                    hash.add(String.valueOf(i), new Borsch());
                    tree.add(String.valueOf(i), new Borsch());
                    break;
                case 1:
                    hash.add(String.valueOf(i), new PorkChop());
                    tree.add(String.valueOf(i), new PorkChop());
                    break;
                case 2:
                    hash.add(String.valueOf(i), new StewedCabbage());
                    tree.add(String.valueOf(i), new StewedCabbage());
                    break;
            }
        }
        System.out.println("2.1.Ветрина на основее HashMap");
        hash.print();
        System.out.println("2.2.Ветрина на основее TreeMap");
        hash.print();
        System.out.println("3. Дозополняем ветрины");
        int size = 1000000;
        Date start = new Date();
        for (int i = 10; i < size; i++) {
            switch (rnd.nextInt(3)){
                case 0:
                    hash.add(String.valueOf(i), new Borsch());
                    break;
                case 1:
                    hash.add(String.valueOf(i), new PorkChop());
                    break;
                case 2:
                    hash.add(String.valueOf(i), new StewedCabbage());
                    break;
            }
        }
        System.out.printf("Время дозаполнения HashMap: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (int i = 10; i < size; i++) {
            switch (rnd.nextInt(3)){
                case 0:
                    tree.add(String.valueOf(i), new Borsch());
                    break;
                case 1:
                    tree.add(String.valueOf(i), new PorkChop());
                    break;
                case 2:
                    tree.add(String.valueOf(i), new StewedCabbage());
                    break;
            }
        }
        System.out.printf("Время дозаполнения TreeMap: %1$s мс\n", new Date().getTime() - start.getTime());
        System.out.println("4. Сравнение времени поиска");
        int sizePool = 10000;
        start = new Date();
        for (int i = 0; i < sizePool; i++) {
            Food temp = hash.search(String.valueOf(rnd.nextInt(size)));
        }
        System.out.printf("Время поиска HashMap: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (int i = 0; i < sizePool; i++) {
            Food temp = tree.search(String.valueOf(rnd.nextInt(size)));
        }
        System.out.printf("Время поиска TreeMap: %1$s мс\n", new Date().getTime() - start.getTime());
    }

    static void showSampleOptimization() {
        System.out.println("Оптимизация перебора Map");
        Date start;
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            String value = String.valueOf(i);
            map.put(value, value);
        }
        start = new Date();
        for (String s : map.keySet()) {
            String temp = "key = " + s + ", val " + map.get(s);
        }
        System.out.printf("Время выполнения по исходному сценарию: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (Map.Entry<String, String> s : map.entrySet()) {
            String temp = "key = " + s.getKey() + ", val " + s.getValue();
        }
        System.out.printf("Время выполнения по оптимизированному сценарию: %1$s мс\n", new Date().getTime() - start.getTime());
        System.out.println("-------------------------------------------");
        System.out.println("Последовательный перебор List");
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
        start = new Date();
        for (int i = 0; i < linkedList.size(); i++) {
            String temp = "Value[i] = " + linkedList.get(i);
        }
        System.out.printf("Время выполнения рандомного доступа LinkedList: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (int i = 0; i < arrayList.size(); i++) {
            String temp = "Value[i] = " + arrayList.get(i);
        }
        System.out.printf("Время выполнения рандомного доступа ArrayList: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (int value : linkedList) {
            String temp = "Value[i] = " + value;
        }
        System.out.printf("Время выполнения через итератор на LinkedList: %1$s мс\n", new Date().getTime() - start.getTime());
        start = new Date();
        for (int value : arrayList) {
            String temp = "Value[i] = " + value;
        }
        System.out.printf("Время выполнения через итератор на ArrayList: %1$s мс\n", new Date().getTime() - start.getTime());
    }
}
