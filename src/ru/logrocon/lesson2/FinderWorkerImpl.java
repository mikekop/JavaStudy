package ru.logrocon.lesson2;


import java.util.ArrayList;
import java.util.Scanner;

public class FinderWorkerImpl implements Worker {

    ArrayList<Food> foodList;

    public FinderWorkerImpl() {
        foodList = new ArrayList<>();
    }

    public ArrayList<Food> findFoodByName(String name) {
        ArrayList<Food> result = new ArrayList<Food>();
        if (name != null && !name.isEmpty()) {
            for(Food food : foodList){
              if (food.getName().toLowerCase().contains(name.toLowerCase())){
                    result.add(food);
                }
            }
        }
        else {
            System.out.println("Не задан поиск");
        }
        return result;
    }
    @Override
    public void start() {
        fill();
        find();
    }

    public void fill() {
        foodList.add(new Course("Окрошка",Types.First, Types.NoHot, Types.Lite));
        foodList.add(new Course("Щи", Types.First, Types.Hot, Types.NoLite));
        foodList.add(new Course("Борщ", Types.First,Types.Hot, Types.NoLite));
        foodList.add(new Course("Омлет", Types.Second, Types.Hot, Types.Lite));
        foodList.add(new Course("Шашлык", Types.Second, Types.Hot, Types.Lite));
        foodList.add(new Course("Эклер", Types.Desert, Types.NoHot));
        foodList.add(new Course("Ватрушка", Types.Desert, Types.NoHot));
    }

    public void find() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст для поиска");
        String inputStr = sc.next();
        if(inputStr.isEmpty()) {
            System.out.println("Не введен текст для поиска");
        }
        else {
            ArrayList<Food> result = findFoodByName(inputStr);
            if (result != null) {
                if (result.isEmpty()) {
                    System.out.println("Ничего не нйдено");
                }
                else if (result.size() == 1) {
                    System.out.println(String.format("Найден один объект %s", result.get(0).getInfo()));
                }
                else {
                    System.out.println(String.format("Найдено %s элементов", result.size()));
                    System.out.println("Вывести упорядоченно по названию?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    if(sc.hasNextInt()) {
                        switch (sc.nextInt()) {
                            case 1:
                                result.sort(Utils.NameComparator);
                                break;
                                default:
                                    System.out.println("Мимо, по этому не упорядочено");
                        }
                    }
                    for (Food food: result) {
                        System.out.println(food.getInfo());
                    }
                }
            }
        }
    }


}
