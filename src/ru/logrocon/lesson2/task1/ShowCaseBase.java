package ru.logrocon.lesson2.task1;

import ru.logrocon.lesson1.Food;
import ru.logrocon.lesson1.food.Cookie;
import ru.logrocon.lesson1.food.FirstCourse;
import ru.logrocon.lesson1.food.Pie;
import ru.logrocon.lesson1.food.SecondCourse;

import java.util.Map;
import java.util.Scanner;

public abstract class ShowCaseBase implements ShowCase {

    /**
     * Витрина продуктов
     */
    protected Map<String, Food> showCase;

    /**
     * Запуск работы витрины
     */
    public void work() {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить блюдо на витрину");
            System.out.println("2 - Удалить блюдо с витрины");
            System.out.println("3 - Показать витрину");
            System.out.println("4 - Найти блюдо");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        add();
                        break;
                    case 2:
                        remove();
                        break;
                    case 3:
                        show();
                        break;
                    case 4:
                        find();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Введите 1 - 4 или 0");
                }
            } else {
                System.out.println("Неверный ввод");
            }
        } while (var != 0);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        int var = -1;
        do {
            System.out.println("Выберите тип:");
            System.out.println("1 - Первое блюдо");
            System.out.println("2 - Второе блюдо");
            System.out.println("3 - Пирог");
            System.out.println("4 - Печеньки");
            System.out.println("0 - Выход");

            if (sc.hasNextInt()) {
                var = sc.nextInt();
                switch (var) {
                    case 1:
                        add(new FirstCourse());
                        var = 0;
                        break;
                    case 2:
                        add(new SecondCourse());
                        var = 0;
                        break;
                    case 3:
                        add(new Pie());
                        var = 0;
                        break;
                    case 4:
                        add(new Cookie());
                        var = 0;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Введите 1 - 4 или 0");
                }
            } else {
                System.out.println("Неверный ввод");
            }
        } while (var != 0);
    }

    /**
     * Добавить переданный продукт на витрину
     */
    private void add(Food food) {
        Scanner sc = new Scanner(System.in);
        String var = "";
        do {
            System.out.print("Введите наименование: ");

            if (sc.hasNextLine()) {
                var = sc.nextLine();
                showCase.put(var, food);
            }
        } while (var.isEmpty());
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);
        String var = "";
        do {
            System.out.print("Введите наименование: ");

            if (sc.hasNextLine()) {
                var = sc.nextLine();
                showCase.remove(var);
            }
        } while (var.isEmpty());
    }

    @Override
    public void show() {
        for (Map.Entry<String, Food> sf : showCase.entrySet()) {
            System.out.printf("%s - \"%s\"%n", sf.getValue().toString(), sf.getKey());
        }
        System.out.println();
    }

    @Override
    public void find() {
        Scanner sc = new Scanner(System.in);
        String var = "";
        do {
            System.out.print("Введите наименование для поиска: ");

            if (sc.hasNextLine()) {
                var = sc.nextLine();

                Food f = showCase.get(var);
                if (f != null) {
                    System.out.printf("Найденное блюдо: %s%n", f.toString());
                } else {
                    System.out.println("Блюдо не найдено");
                }
            }
        } while (var.isEmpty());
    }
}
